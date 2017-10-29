package com.zetaglobal.expression.evaluator.expressionevaluator.expression;

import java.util.List;

/**
 * @author Sourabh Aggarwal
 */
public class Node {

    private NodeData nodeData;
    private List<Node> nodes;

    public Node() {
    }

    public Node(NodeData nodeData, List<Node> nodes) {
        this.nodeData = nodeData;
        this.nodes = nodes;
    }

    public NodeData getNodeData() {
        return nodeData;
    }

    public void setNodeData(NodeData nodeData) {
        this.nodeData = nodeData;
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }

    @Override
    public String toString() {
        return "Node{" + "nodeData=" + nodeData + ", nodes=" + nodes.toString() + '}';
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nodeData == null) ? 0 : nodeData.hashCode());
        result = prime * result + ((nodes == null) ? 0 : nodes.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Node other = (Node) obj;
        if (nodeData == null) {
            if (other.nodeData != null)
                return false;
        } else if (!nodeData.equals(other.nodeData))
            return false;
        if (nodes == null) {
            if (other.nodes != null)
                return false;
        } else if (!nodes.equals(other.nodes))
            return false;
        return true;
    }
}