package io.github.domig.tasks;

import java.io.Serializable;

class Tasks  implements Serializable {

    private String name;
    private int numberOfTasks;
    private int numberOfTasksDone;

    Tasks(String name, int numberOfTasks, int numberOfTasksDone) {
        this.name = name;
        this.numberOfTasks = numberOfTasks;
        this.numberOfTasksDone = numberOfTasksDone;
    }

    String getName() {
        return name;
    }

//    public void setName(String name) {
//        this.name = name;
//    }

    int getNumberOfTasks() {
        return numberOfTasks;
    }

//    public void setNumberOfTasks(int numberOfTasks) {
//        this.numberOfTasks = numberOfTasks;
//    }

    int getNumberOfTasksDone() {
        return numberOfTasksDone;
    }

//    public void setNumberOfTasksDone(int numberOfTasksDone) {
//        this.numberOfTasksDone = numberOfTasksDone;
//    }
}
