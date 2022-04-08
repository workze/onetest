package com.dataflow;

import facade.JavaDataFlow;
import facade.StaticJavaDataFlow;
import model.*;

import java.util.List;

/**
 * @author wangguize
 * @date 2022/2/23
 */
public class DataFlowTest {

    public static void main(String[] args) {
        StaticJavaDataFlow.getConfig().setProjectPaths("/Users/wangguize/gitlab/onetest/dataflow/src/test/java");
        DataFlowGraph dfg = JavaDataFlow.create("/Users/wangguize/gitlab/onetest/dataflow/src/test/java/com/test/App.java");

        DataFlowMethod get = dfg.getMethods().stream().filter(m -> m.getName().equals("get1")).findFirst().get();

        // System.out.println(dfg);
        // DataFlowGraph dfg = JavaDataFlow.create("/Users/wangguize/gitlab/onetest/dataflow/src/test/java/com/test/Main.java");
        // final DataFlowMethod setUserIdMethod = dfg.getMethods().stream().filter(m -> m.getName().equals("setUserId")).findFirst().get();
        // final DataFlowNode dataFlowNode = setUserIdMethod.getInputParameters().getNodes().get(0);
        // List<DataFlowNode> inputNodes = get.getReturnNode().get().walkBackUntil(DataFlowNode::isInputParameter, dfg::owns);
        // System.out.println(inputNodes.get(0).getName());
        List<DataFlowNode> inputNodes = get.getReturnNode().get().walkBackUntil((node) -> {
            final OwnedNode<?> ownedNode = node.getOwner().orElse(null);
            if (ownedNode != null) {
                System.out.println("====" + ownedNode.getRepresentedNode());
            }
            return false;
        }, dfg::owns);
        System.out.println();
    }

}
