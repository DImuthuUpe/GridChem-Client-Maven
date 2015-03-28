package nanocad.minimize.mm3;

/**
 * lterm.java - MM2-style length energy term
 * Copyright (c) 1997,1998 Will Ware, all rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and other materials provided with the distribution.
 * 3. All advertising materials mentioning features or use of this software
 *    or its derived works must display the following acknowledgement:
 * 	This product includes software developed by Will Ware.
 * 
 * This software is provided "as is" and any express or implied warranties,
 * including, but not limited to, the implied warranties of merchantability
 * or fitness for any particular purpose are disclaimed. In no event shall
 * Will Ware be liable for any direct, indirect, incidental, special,
 * exemplary, or consequential damages (including, but not limited to,
 * procurement of substitute goods or services; loss of use, data, or
 * profits; or business interruption) however caused and on any theory of
 * liability, whether in contract, strict liability, or tort (including
 * negligence or otherwise) arising in any way out of the use of this
 * software, even if advised of the possibility of such damage.
 */

import java.lang.Math;
import java.util.Vector;
import nanocad.*;

public class hbondterm extends nanocad.term
{
  public static final String rcsid =
	"$Id: hbondterm.java,v 1.2 2005/05/14 23:51:02 xli16 Exp $";
  /* I've been hacking a bit with acceptable forms for the length-energy term.
   * _Nanosystems_ lists one simple expression with a square and cubic term
   * for close distances, and various kinds of exponential expressions for
   * farther away. But these depend on numbers called De and beta and I don't
   * have tables for those (just the few examples in _Nanosystems_). So after
   * some puttering and graphing and algebra, I came up with the following.
   * Energies are in attojoules (10^-18 joules), distances are in angstroms
   * (10^-10 m), forces are in attojoules per angstrom (10^-8 N), and
   * spring constants are in attojoules per angstrom-squared (100 N/m). This
   * is consistent with the units in _Nanosystems_, and also the units used
   * in the 'mm2.prm' parameter file I found on Jay Ponder's ftp site.
   * Expressions for energy and force, where ks and r0 are a function of
   * the two atoms involved:
   *
   *   dr = r - r0;
   *
   * Energy (r) :=
   *   if (dr < rthresh)
   *     { return 0.5 * ks * dr * dr * (1 - kc * dr) - z * ks; }
   *   else
   *     { return (-a * ks / beta) * exp (-beta * dr); }
   *
   * Force (r) :=
   *   if (dr < rthresh)
   *     { return -(ks * dr * (1 - 1.5 * kc * dr)); }
   *   else
   *     { return -a * ks * exp (-beta * dr); }
   *
   *
   * A, beta, z, kcubic, and rthresh are defined below. Notice my use of
   * 'beta' differs from the use in _Nanosystems_, but plays a similar role.
   *
   * These follow Drexler's quadratic-cubic form for dr < rthresh, and for
   * dr > rthresh, they follow an exponential drop-off which is pretty
   * continuous for both energy and force. The only point that I think would
   * be worth quibbling over would be the value of beta, which I picked so
   * that it would look "reasonable" on a graph.
   */
  private static final double kcubic = 2.0;            /* (0.5 angstrom)^-1 */
  private static final double rthresh = 1 / (3 * kcubic);
  private static final double beta = 3.0;
  private static final double a = rthresh * (1 - 1.5 * kcubic * rthresh) *
	Math.exp (beta * rthresh);
  private static final double z = (a / beta) * Math.exp(-beta * rthresh) +
	0.5 * rthresh * rthresh * (1 - kcubic * rthresh);
	public final static double B = 2.55;
	public final static double C = .583333;
	private double pij;
	private double Dij;
	public final static double MIN_ANGLE_FOR_HBOND = 150.0/180.0 * Math.PI;//150 degrees in radians
	public final static double MAX_LENGTH_FOR_HBOND = 3.5;
/**
 * Insert the method's description here.
 * Creation date: (6/19/00 4:09:33 PM)
 */
public hbondterm() {}
public hbondterm(atom a1, atom a2, atom a3) {
	myAtoms = new atom[3];
	myAtoms[0] = a1;
	myAtoms[1] = a2;
	myAtoms[2] = a3;
	setCalculationValues();
}
  protected void buildTerm (Vector v, Vector termList)
	{
		System.err.println("buildTerm for hbond term should never be called.");
	}

protected boolean canFormHBonds(atom a) {
	int atomicNumber = a.atomicNumber();
	if((atomicNumber == 7) || (atomicNumber == 8) || (atomicNumber == 16))
		return true; 
	return false;
}
public double computeForces() {

	if(defaultsUsed()) return 0.0;
	
	int i;
	// compute forces on each atom, add it to the atom's force vector
	double[] diff = new double[3];
	double r, m;
	for (i = 0, r = 0.0; i < 3; i++) {
		diff[i] = myAtoms[0].x[i] - myAtoms[1].x[i];
		r += diff[i] * diff[i];
	}
	if(r <= 0) r = mm3MinimizeAlgorythm.TINY;
	r = Math.sqrt(r);

	potential = computePotential(r);
	m = computePotentialDerivative(r);

	// at this point, m is du/dr
	m /= r;
	// m > 0 attract, m < 0 repel
	for (i = 0; i < 3; i++) {
		myAtoms[0].f[i] -= m * diff[i];
		myAtoms[1].f[i] += m * diff[i];
	}
	//return m * Math.sqrt(diff[0] * diff[0] + diff[1] * diff[1] + diff[2] * diff[2]);
	return m*r;
}
/**
 * Insert the method's description here.
 * Creation date: (6/15/00 1:22:01 PM)
 * @return double
 * @param lengthDifference double
 */
protected double computePotentialDerivative(double p) {
	//p is the acutal distance between atoms
	double exponentForE = -12*p/pij;
	double firstTerm = -2.208e6*Math.pow(Math.E, exponentForE)/pij;
	double secondTerm;
	if (p < (pij/3))
	{
		secondTerm = 4.5*Math.pow(pij, 2.0)/Math.pow(p, 3.0);
	}
	else
	{
		secondTerm = 13.5*Math.pow(pij, 6.0)/Math.pow(p, 7.0);
	}
			
	double force = Dij*(firstTerm + secondTerm);;
	return force;
}

protected double computePotential(double p){
	return (Dij * ( 1.84E5 * Math.exp(-12 * p / pij) - 2.25 * Math.pow(pij / p, 6)));
}

public void enumerate(Vector atomList, Vector termList)
{
	for(int i = 0; i < atomList.size(); i++)
	{
		atom hydrogen = (atom) atomList.elementAt(i);
		if(hydrogen.atomicNumber() == 1)
		{
			for (int k = 0; k < hydrogen.bonds.size(); k++)
			{
				atom currentAtom = (atom) ((bond) hydrogen.bonds.elementAt(k)).otherAtom(hydrogen);
				if(canFormHBonds(currentAtom))
				{
					for(int j = 0; j < atomList.size(); j++)
					{
						atom otherAtom = (atom) atomList.elementAt(j);
						if(otherAtom == currentAtom)
							continue;
						if(!canFormHBonds(otherAtom))
							continue;
						if(findAngle(currentAtom, hydrogen, otherAtom) < MIN_ANGLE_FOR_HBOND)
							continue;
						if(lengthBetween(currentAtom, hydrogen) + lengthBetween(hydrogen, otherAtom) > MAX_LENGTH_FOR_HBOND)
							continue;

						termList.addElement(new hbondterm(currentAtom, hydrogen, otherAtom));
					}
				}
			}
		}
	}	

}
  protected String repr2()
	{
	  return " length " +
	(new Double(pij)).toString() + " " +
	(new Double(Dij)).toString();
	}
protected void setCalculationValues() {
	int atomOneType = myAtoms[0].getMM3TypeNum();
	int atomTwoType = myAtoms[2].getMM3TypeNum();
	if (atomOneType < 0 || atomTwoType < 0) {
		setDefaultCalculationValues();
		return;
	}
	int biggerValue = Math.max(atomOneType, atomTwoType);
	int smallerValue = Math.min(atomOneType, atomTwoType);
	try {
		AtomDataFile dataFile = new AtomDataFile(newNanocad.txtDir + 
				newNanocad.fileSeparator + "mm3hbonddata.txt");
		//AtomDataFile dataFile = new AtomDataFile("mm3hbonddata.txt");
		if (dataFile.findData(smallerValue, biggerValue, 0, 1)) {
			pij = dataFile.parseDouble(2);
			Dij = dataFile.parseDouble(3);
		} else {
			setDefaultCalculationValues();
			return;
		}
	} catch (java.io.IOException e) {
		System.err.println("Length data lookup error");
		e.printStackTrace();
	}
}
/**
 * Insert the method's description here.
 * Creation date: (6/19/00 1:50:46 PM)
 */
protected void setDefaultCalculationValues()
{
	defaultsUsed = true;
	System.err.println("No data for " + myAtoms[0].getMM3TypeNum() + " " + myAtoms[2].getMM3TypeNum() + " hydrogen bond");
}
  public int termLength()
	{
	  return 2;
	}
  public String name()
  {
	return "Hydrogen bond";
  }
}
