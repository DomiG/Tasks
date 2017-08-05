package io.github.domig.tasks;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseButton;
import java.io.*;
import java.net.URL;
import java.util.*;

public class Controller implements Initializable {
    @Override  @SuppressWarnings("unchecked")
    public void initialize(URL location, ResourceBundle resources) {
        // System.out.println(task1Label.getText().toString());
        task1Progress.textProperty().addListener((observable, oldValue, newValue) -> {
            //System.out.println("textfield changed from " + oldValue + " to " + newValue);
            int i2 = Integer.parseInt(newValue.replaceAll("[\\D]", ""));
            updateProgressBar(1, i2);
        });
        task2Progress.textProperty().addListener((observable, oldValue, newValue) -> {
            //System.out.println("textfield changed from " + oldValue + " to " + newValue);
            int i2 = Integer.parseInt(newValue.replaceAll("[\\D]", ""));
            updateProgressBar(2, i2);
        });
        task3Progress.textProperty().addListener((observable, oldValue, newValue) -> {
            //System.out.println("textfield changed from " + oldValue + " to " + newValue);
            int i2 = Integer.parseInt(newValue.replaceAll("[\\D]", ""));
            updateProgressBar(3, i2);
        });
        task4Progress.textProperty().addListener((observable, oldValue, newValue) -> {
            //System.out.println("textfield changed from " + oldValue + " to " + newValue);
            int i2 = Integer.parseInt(newValue.replaceAll("[\\D]", ""));
            updateProgressBar(4, i2);
        });
        bookProgress.textProperty().addListener((observable, oldValue, newValue) -> {
            updateProgressBar(5, 1);
            String s = bookComboBox.getPromptText();
            b.updateBookProgress(s, newValue);
        });

        bookComboBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) ->
                matchBookProgress(newValue));

        task1Label.setOnMouseClicked(event -> {
            if(event.getButton().equals(MouseButton.PRIMARY)){
                if(event.getClickCount() == 2){
                    labelDoubleClicked(1);

                }
            }
        });
        task2Label.setOnMouseClicked(event -> {
            if(event.getButton().equals(MouseButton.PRIMARY)){
                if(event.getClickCount() == 2){
                    labelDoubleClicked(2);

                }
            }
        });
        task3Label.setOnMouseClicked(event -> {
            if(event.getButton().equals(MouseButton.PRIMARY)){
                if(event.getClickCount() == 2){
                    labelDoubleClicked(3);

                }
            }
        });
        task4Label.setOnMouseClicked(event -> {
            if(event.getButton().equals(MouseButton.PRIMARY)){
                if(event.getClickCount() == 2){
                    labelDoubleClicked(4);

                }
            }
        });

        loadTasks();
        updateAllProgressBars();
    }

    //region FXML
    @FXML
    Label bookTitleLabel;
    @FXML
    Label task1Label;
    @FXML
    Label task2Label;
    @FXML
    Label task3Label;
    @FXML
    Label task4Label;
    @FXML
    Label task1ProgressLabel;
    @FXML
    Label task2ProgressLabel;
    @FXML
    Label task3ProgressLabel;
    @FXML
    Label task4ProgressLabel;
    @FXML
    ProgressBar task1ProgressBar;
    @FXML
    ProgressBar task2ProgressBar;
    @FXML
    ProgressBar task3ProgressBar;
    @FXML
    ProgressBar task4ProgressBar;
    @FXML
    ProgressBar bookProgressBar;
    @FXML
    TextField task1Progress;
    @FXML
    TextField task2Progress;
    @FXML
    TextField task3Progress;
    @FXML
    TextField task4Progress;
    @FXML
    TextField bookProgress;
    @FXML
    ComboBox bookComboBox;
    @FXML
    CheckBox moCheckBox;
    @FXML
    CheckBox tuCheckBox;
    @FXML
    CheckBox weCheckBox;
    @FXML
    CheckBox thCheckBox;
    @FXML
    CheckBox frCheckBox;
    //endregion

    private void matchBookProgress(Object newValue){
        List<Book> bookList = b.getBookList();

        if(newValue != null){
            for (Book b : bookList) {
                if (b.getTitle().equals(newValue.toString())) {
                    bookProgress.setText(Integer.toString(b.getPercentage()));
                }
            }
        }
    }

    private void updateProgressBar(int task, int progress) {
        int i;
        double d;
        switch (task) {
            case 1:
                i = Integer.parseInt(task1ProgressLabel.getText().replaceAll("[\\D]", ""));
                d = (double) progress / (double) i;

//                System.out.println(d);
                task1ProgressBar.setProgress(d);
                break;
            case 2:
                i = Integer.parseInt(task2ProgressLabel.getText().replaceAll("[\\D]", ""));
                d = (double) progress / (double) i;
//                System.out.println(d);
                task2ProgressBar.setProgress(d);
                break;
            case 3:
                i = Integer.parseInt(task3ProgressLabel.getText().replaceAll("[\\D]", ""));
                d = (double) progress / (double) i;
//                System.out.println(d);
                task3ProgressBar.setProgress(d);
                break;
            case 4:
                i = Integer.parseInt(task4ProgressLabel.getText().replaceAll("[\\D]", ""));
                d = (double) progress / (double) i;
//                System.out.println(d);
                task4ProgressBar.setProgress(d);
                break;
            case 5:
                i = Integer.parseInt(bookProgress.getText().replaceAll("[\\D]", ""));
                double bProgress = ((double) i / 100);
                bookProgressBar.setProgress(bProgress);
                b.updateBookProgress(bookComboBox.getSelectionModel().getSelectedItem().toString(), bookProgress.getText());
        }
    }

    private Book b = new Book("x", 0);



    @FXML
    private void saveButtonPressed() {

        saveTasks();
    }

    private void saveTasks() {

        int numberOfTasks = Integer.parseInt(task1ProgressLabel.getText().replaceAll("[\\D]", ""));
        int numberOfTasksDone = Integer.parseInt(task1Progress.getText().replaceAll("[\\D]", ""));
        Tasks task1 = new Tasks(task1Label.getText(), numberOfTasks, numberOfTasksDone);

        int numberOfTasks2 = Integer.parseInt(task2ProgressLabel.getText().replaceAll("[\\D]", ""));
        int numberOfTasksDone2 = Integer.parseInt(task2Progress.getText().replaceAll("[\\D]", ""));
        Tasks task2 = new Tasks(task2Label.getText(), numberOfTasks2, numberOfTasksDone2);

        int numberOfTasks3 = Integer.parseInt(task3ProgressLabel.getText().replaceAll("[\\D]", ""));
        int numberOfTasksDone3 = Integer.parseInt(task3Progress.getText().replaceAll("[\\D]", ""));
        Tasks task3 = new Tasks(task3Label.getText(), numberOfTasks3, numberOfTasksDone3);

        int numberOfTasks4 = Integer.parseInt(task4ProgressLabel.getText().replaceAll("[\\D]", ""));
        int numberOfTasksDone4 = Integer.parseInt(task4Progress.getText().replaceAll("[\\D]", ""));
        Tasks task4 = new Tasks(task4Label.getText(), numberOfTasks4, numberOfTasksDone4);

//        int percentage = Integer.parseInt(bookProgress.getText().replaceAll("[\\D]", ""));
//        Tasks taskBook = new Tasks(bookTitleLabel.getText(), percentage, 5);

        ArrayList<Tasks> TaskList = new ArrayList<>();
        TaskList.add(task1);
        TaskList.add(task2);
        TaskList.add(task3);
        TaskList.add(task4);
//        TaskList.add(taskBook);

        ArrayList<? extends Integer> a = makeCheckBoxArray();

        try {
            FileOutputStream fileOut = new FileOutputStream("tasks.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(TaskList);
            out.writeObject(a);
            out.writeObject(b.getBookList());
            out.close();
            fileOut.close();
//            System.out.println("serialized");
        } catch (IOException ex) {
            System.out.println("IOException");
        }
    }


    private ArrayList<? extends Integer> makeCheckBoxArray() {
        ArrayList<Integer> a = new ArrayList<>();
        if (moCheckBox.isSelected()) {
            a.add(1);
        } else {
            a.add(0);
        }
        if (tuCheckBox.isSelected()) {
            a.add(1);
        } else {
            a.add(0);
        }
        if (weCheckBox.isSelected()) {
            a.add(1);
        } else {
            a.add(0);
        }
        if (thCheckBox.isSelected()) {
            a.add(1);
        } else {
            a.add(0);
        }
        if (frCheckBox.isSelected()) {
            a.add(1);
        } else {
            a.add(0);
        }

        return a;
    }

    private void updateAllProgressBars(){
        int i;
        double d;
        int progress;
        i = Integer.parseInt(task1ProgressLabel.getText().replaceAll("[\\D]", ""));
        progress = Integer.parseInt(task1Progress.getText().replaceAll("[\\D]", ""));
        d = (double) progress / (double) i;
        task1ProgressBar.setProgress(d);
        i = Integer.parseInt(task2ProgressLabel.getText().replaceAll("[\\D]", ""));
        progress = Integer.parseInt(task2Progress.getText().replaceAll("[\\D]", ""));
        d = (double) progress / (double) i;
        task2ProgressBar.setProgress(d);
        i = Integer.parseInt(task3ProgressLabel.getText().replaceAll("[\\D]", ""));
        progress = Integer.parseInt(task3Progress.getText().replaceAll("[\\D]", ""));
        d = (double) progress / (double) i;
        task3ProgressBar.setProgress(d);
        i = Integer.parseInt(task4ProgressLabel.getText().replaceAll("[\\D]", ""));
        progress = Integer.parseInt(task4Progress.getText().replaceAll("[\\D]", ""));
        d = (double) progress / (double) i;
        task4ProgressBar.setProgress(d);
    }

    @FXML
    private void loadButtonPressed(){
        loadTasks();
    }

    @SuppressWarnings("unchecked")
    private void loadTasks(){
        ArrayList<Tasks> TaskList;
        ArrayList<Integer> checkList;
        try {
            FileInputStream fileIn = new FileInputStream("tasks.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            TaskList = (ArrayList<Tasks>) in.readObject();
            checkList = (ArrayList<Integer>) in.readObject();
            List<Book> bookList  = (ArrayList<Book>) in.readObject();
            b.loadBookList(bookList);
            in.close();
            fileIn.close();
        }catch(IOException i) {
            i.printStackTrace();
            return;
        }catch(ClassNotFoundException c) {
            System.out.println("class not found");
            c.printStackTrace();
            return;
        }
        int i = 1;

        for (Tasks k : TaskList){
            loadTaskProgress(k, i);
            i++;
        }

        int i2 = 1;
        for (int checked : checkList){
            loadCheckBoxes(checked, i2);
            i2++;
        }

        updateComboBox();
    }


    private void loadCheckBoxes(int checked, int count) {

        switch (count){
            case 1: if(checked == 1){
                moCheckBox.setSelected(true);

            }else{
                moCheckBox.setSelected(false);
            }
                break;
            case 2: if(checked == 1){
                tuCheckBox.setSelected(true);
            }else{
                tuCheckBox.setSelected(false);
            }
                break;

            case 3: if(checked == 1){
                weCheckBox.setSelected(true);
            }
            else{
                weCheckBox.setSelected(false);
            }
                break;
            case 4: if(checked == 1){
                thCheckBox.setSelected(true);
            }
            else{
                thCheckBox.setSelected(false);
            }
                break;
            case 5: if(checked == 1){
                frCheckBox.setSelected(true);
            }
            else{
                frCheckBox.setSelected(false);
            }
                break;
        }
    }

    private void loadTaskProgress(Tasks k, int i){

        int i2 = k.getNumberOfTasks();
        int i3 = k.getNumberOfTasksDone();
        switch (i){
            case 1:
                task1Label.setText(k.getName());
                task1Progress.setText(Integer.toString(i3));
                task1ProgressLabel.setText("/" + Integer.toString(i2));
                break;

            case 2:
                task2Label.setText(k.getName());
                task2Progress.setText(Integer.toString(i3));
                task2ProgressLabel.setText("/" + Integer.toString(i2));
                break;


            case 3:
                task3Label.setText(k.getName());
                task3Progress.setText(Integer.toString(i3));
                task3ProgressLabel.setText("/" + Integer.toString(i2));
                break;


            case 4:
                task4Label.setText(k.getName());
                task4Progress.setText(Integer.toString(i3));
                task4ProgressLabel.setText("/" + Integer.toString(i2));
                break;

//            case 5:
//                bookTitleLabel.setText(k.getName());
//                bookProgress.setText(Integer.toString(i2));


        }

    }

    @FXML
    private void config1ButtonPressed() {
        addProgressLabel(1);
    }

//    private StringProperty getLabelTextProperty() {
//        return task1Label.textProperty();
//    }

    @FXML
    private void config2ButtonPressed(){
        addProgressLabel(2);
    }

    @FXML
    private void config3ButtonPressed(){
        addProgressLabel(3);
    }

    @FXML
    private void config4ButtonPressed(){
        addProgressLabel(4);
    }

    @FXML
    private void bookConfigButtonPressed() {
        TextInputDialog dialog = new TextInputDialog("");
        dialog.setTitle("Book title");
        dialog.setHeaderText("Book title");
        dialog.setContentText("Please enter book title here:");

        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()){
            Book a = new Book(result.get(), 0);
            b.addBook(a);
            updateComboBox();

        }
    }

    @SuppressWarnings("unchecked")
    private void updateComboBox(){
        //bookComboBox.getSelectionModel().clearSelection();
        bookComboBox.getItems().clear();
        List<Book> bookList = b.getBookList();
        for (Book bb : bookList){
            if (bb != null) {
                bookComboBox.getItems().add(bb.getTitle());
            }
        }
        bookComboBox.getSelectionModel().selectFirst();
    }


    @FXML
    private void minusButton1Pressed(){
        int i =Integer.parseInt(task1Progress.getText().replaceAll("[\\D]", ""));
        task1Progress.setText(Integer.toString(i-1));
    }
    @FXML
    private void minusButton2Pressed(){
        int i =Integer.parseInt(task2Progress.getText().replaceAll("[\\D]", ""));
        task2Progress.setText(Integer.toString(i-1));
    }
    @FXML
    private void minusButton3Pressed(){
        int i =Integer.parseInt(task3Progress.getText().replaceAll("[\\D]", ""));
        task3Progress.setText(Integer.toString(i-1));
    }
    @FXML
    private void minusButton4Pressed(){
        int i =Integer.parseInt(task4Progress.getText().replaceAll("[\\D]", ""));
        task4Progress.setText(Integer.toString(i-1));
    }
    @FXML
    private void plusButton1Pressed(){
        int i =Integer.parseInt(task1Progress.getText().replaceAll("[\\D]", ""));
        task1Progress.setText(Integer.toString(i+1));
    }
    @FXML
    private void plusButton2Pressed(){
        int i =Integer.parseInt(task2Progress.getText().replaceAll("[\\D]", ""));
        task2Progress.setText(Integer.toString(i+1));
    }
    @FXML
    private void plusButton3Pressed(){
        int i =Integer.parseInt(task3Progress.getText().replaceAll("[\\D]", ""));
        task3Progress.setText(Integer.toString(i+1));
    }
    @FXML
    private void plusButton4Pressed(){
        int i =Integer.parseInt(task4Progress.getText().replaceAll("[\\D]", ""));
        task4Progress.setText(Integer.toString(i+1));
    }



    private void addProgressLabel(int i){
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Number of Tasks " + i);
        dialog.setHeaderText("Number of Tasks " + i);
        dialog.setContentText("Number of Tasks " + i + ":");

        switch(i){
            case 1:
                //dialog.getEditor().setText(task1Label.getText());
                Optional<String> result = dialog.showAndWait();
                result.ifPresent(s -> task1ProgressLabel.setText("/" + s));
                break;
            case 2: Optional<String> result2 = dialog.showAndWait();
                result2.ifPresent(s -> task2ProgressLabel.setText("/" + s));
                break;
            case 3:
                Optional<String> result3 = dialog.showAndWait();
                result3.ifPresent(s -> task3ProgressLabel.setText("/" + s));
                break;
            case 4:Optional<String> result4 = dialog.showAndWait();
                result4.ifPresent(s -> task4ProgressLabel.setText("/" + s));
                break;
            //default: task1ProgressLabel.setText("/01");
        }

    }

    private void labelDoubleClicked(int i){
        TextInputDialog dialog = new TextInputDialog("");
        dialog.setTitle("Task name " + i);
        dialog.setHeaderText("Task name " + i);
        dialog.setContentText("Please enter task name " + i  + " here");


        switch(i) {
            case 1:
                Optional<String> result = dialog.showAndWait();
                result.ifPresent(s -> task1Label.setText(s));
                break;
            case 2:
                Optional<String> result2 = dialog.showAndWait();
                result2.ifPresent(s -> task2Label.setText(s));
                break;
            case 3:
                Optional<String> result3 = dialog.showAndWait();
                result3.ifPresent(s -> task3Label.setText(s));
                break;
            case 4:
                Optional<String> result4 = dialog.showAndWait();
                result4.ifPresent(s -> task4Label.setText(s));
                break;
        }

    }
}
