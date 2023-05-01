package org.example;

public class MyTree {
    class Node {
        Student value;
        Node left;
        Node right;

        Node(Student value) {
            this.value = value;
        }
    }

    private Node root;
    private int size;


    private Node addRecursive(Node current, Student student) {
        if (current == null) {
            return new Node(student);
        } else if (student.getIdnp() < current.value.getIdnp()) {
            current.left = addRecursive(current.left, student);
        } else if (student.getIdnp() > current.value.getIdnp()) {
            current.right = addRecursive(current.right, student);
        } else return current;
        return current;
    }

    public void add(Student student) {
        root = addRecursive(root, student);
        size++;
    }

    private boolean existsRecursive(Node current, Student student) {
        if (current == null) return false;
        if (current.value.equals(student)) return true;
        return student.getIdnp() < current.value.getIdnp()
                ? existsRecursive(current.left, student)
                : existsRecursive(current.right, student);
    }

    public boolean exists(Student student) {
        return existsRecursive(root, student);
    }


    public void inOrder() {
        inOrderPrint(root);
    }

    private void inOrderPrint(Node node) {
        if (node == null) {
            return;
        }
        inOrderPrint(node.left);
        System.out.println(node.value);
        inOrderPrint(node.right);
    }

    public void preOrdeer() {
        preOrdeerPrint(root);
    }

    private void preOrdeerPrint(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.value);
        preOrdeerPrint(node.left);
        preOrdeerPrint(node.right);
    }

    public void postOrder() {
        postOrderPrint(root);
    }

    private void postOrderPrint(Node node) {
        if (node == null) {
            return;
        }
        preOrdeerPrint(node.left);
        preOrdeerPrint(node.right);
        System.out.println(node.value);
    }

    public boolean remove(Student student) {
        Node current = root;
        Node previous = current;
        boolean leftChild = false;
        while (current != null) {
            if (current.value.equals(student)) {
                break;
            }
            previous = current;
            if (student.getIdnp() < current.value.getIdnp()) {
                current = current.left;
                leftChild = true;
            } else {
                current = current.right;
                leftChild = false;
            }
        }
        if (current == null) {
            return false;
        }
        if (current.left == null && current.right == null) {
            if (current == root) {
                root = null;
            } else if (leftChild) {
                previous.left = null;
            } else {
                previous.right = null;
            }
            return true;
        } else if (current.left == null) {
            if (current == root) {
                root = null;
            } else if (leftChild) {
                previous.left = null;
            } else {
                previous.right = null;
            }
        } else {
            Node temp = getTemp(current);
            if (current == root) {
                root = null;
            } else if (leftChild) {
                previous.left = temp;
            } else {
                previous.right = temp;
            }
        }
        return true;
    }

    private Node getTemp(Node node) {
        Node previous = node;
        Node current = node.right;
        Node temp = node;
        while (current != null) {
            previous = temp;
            temp = current;
            current = current.left;
        }
        if (temp != current.right) {
            previous.left = temp.right;
            temp.right = node.right;
        }
        return temp;
    }

    public int getSize() {
        return size;
    }
}
