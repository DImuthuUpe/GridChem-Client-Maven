package org.apache.airavata.gridchem.experiment;

import org.apache.airavata.ExpetimentConst;
import org.apache.airavata.gridchem.AiravataManager;
import org.apache.airavata.model.appcatalog.appinterface.DataType;
import org.apache.airavata.model.appcatalog.appinterface.InputDataObjectType;
import org.apache.airavata.model.appcatalog.appinterface.OutputDataObjectType;
import org.apache.airavata.model.util.ExperimentModelUtil;
import org.apache.airavata.model.workspace.experiment.ComputationalResourceScheduling;
import org.apache.airavata.model.workspace.experiment.Experiment;
import org.apache.airavata.model.workspace.experiment.UserConfigurationData;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by dimuthuupeksha on 5/10/15.
 */
public class AddExperimentHandler extends ExperimentHandler{

    public String createExperiment(Map<String, Object> params) throws ExperimentCreationException {

        String projectID = null, userID = null, expName = null, expDesc = null, appId = null, hostID = null, queue = null, projectAccount = null;
        Integer cpuCount = null, threadCount = null, nodeCount = null, wallTime = null, startTime = null, physicalMemory = null;

        if (params.get(ExpetimentConst.PROJECT_ID) != null)
            projectID = (String) params.get(ExpetimentConst.PROJECT_ID);

        if (params.get(ExpetimentConst.USER_ID) != null)
            userID = (String) params.get(ExpetimentConst.USER_ID);

        if (params.get(ExpetimentConst.EXP_NAME) != null)
            expName = (String) params.get(ExpetimentConst.EXP_NAME);

        if (params.get(ExpetimentConst.APP_ID) != null)
            appId = (String) params.get(ExpetimentConst.APP_ID);

        if (params.get(ExpetimentConst.RESOURCE_HOST_ID) != null)
            hostID = (String) params.get(ExpetimentConst.RESOURCE_HOST_ID);

        if (params.get(ExpetimentConst.QUEUE) != null)
            queue = (String) params.get(ExpetimentConst.QUEUE);

        if (params.get(ExpetimentConst.PROJECT_ACCOUNT) != null)
            projectAccount = (String) params.get(ExpetimentConst.PROJECT_ACCOUNT);

        if (params.get(ExpetimentConst.CPU_COUNT) != null)
            cpuCount = (Integer) params.get(ExpetimentConst.CPU_COUNT);

        if (params.get(ExpetimentConst.THREADS) != null)
            threadCount = (Integer) params.get(ExpetimentConst.THREADS);

        if (params.get(ExpetimentConst.NODE_COUNT) != null)
            nodeCount = (Integer) params.get(ExpetimentConst.NODE_COUNT);

        if (params.get(ExpetimentConst.WALL_TIME) != null)
            wallTime = (Integer) params.get(ExpetimentConst.WALL_TIME);

        if (params.get(ExpetimentConst.START_TIME) != null)
            startTime = (Integer) params.get(ExpetimentConst.START_TIME);

        if (params.get(ExpetimentConst.MEMORY) != null)
            physicalMemory = (Integer) params.get(ExpetimentConst.MEMORY);


        List<InputDataObjectType> exIputs = new ArrayList<>();
        InputDataObjectType input1 = new InputDataObjectType();
        input1.setName("x");
        input1.setType(DataType.STRING);
        input1.setValue("23");

        InputDataObjectType input2 = new InputDataObjectType();
        input2.setName("y");
        input2.setType(DataType.STRING);
        input2.setValue("3");

        exIputs.add(input1);
        exIputs.add(input2);

        List<OutputDataObjectType> exOut = new ArrayList<>();
        OutputDataObjectType output = new OutputDataObjectType();
        output.setName("Result");
        output.setType(DataType.STRING);
        output.setValue("");
        exOut.add(output);

        Experiment echoExp =
                ExperimentModelUtil.createSimpleExperiment(null, null, null, null, null, null);
        echoExp.setProjectID(projectID);
        echoExp.setUserName(userID);
        echoExp.setName(expName);
        echoExp.setDescription(expDesc);
        echoExp.setApplicationId(appId);
        echoExp.setExperimentInputs(exIputs);

        ComputationalResourceScheduling scheduling =
                ExperimentModelUtil.createComputationResourceScheduling(null, 0, 0, 0, null, 0, 0, 0, null);

        scheduling.setResourceHostId(hostID);
        scheduling.setTotalCPUCount(cpuCount);
        scheduling.setNodeCount(nodeCount);
        scheduling.setNumberOfThreads(threadCount);
        scheduling.setQueueName(queue);
        scheduling.setWallTimeLimit(wallTime);
        scheduling.setJobStartTime(startTime);
        scheduling.setTotalPhysicalMemory(physicalMemory);
        scheduling.setComputationalProjectAccount(projectAccount);

        UserConfigurationData userConfigurationData = new UserConfigurationData();

        userConfigurationData.setAiravataAutoSchedule(false);
        userConfigurationData.setOverrideManualScheduledParams(false);
        userConfigurationData.setComputationalResourceScheduling(scheduling);
        echoExp.setUserConfigurationData(userConfigurationData);

        String experimentId = null;
        try {
            experimentId = AiravataManager.getClient().createExperiment(echoExp);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ExperimentCreationException("Error at creating experiment "+expName+ " on machine "+hostID,e);
        }
        return experimentId;

    }
}
