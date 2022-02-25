package com.example.redessociales;

import javafx.scene.control.*;
import javafx.scene.layout.Pane;

import static com.example.redessociales.UberSocial.*;

public class HelloController {

    public Pane login, register, redSocial;
    public Button btn_log, addFriend, post, search, btnShow, btnR, btnRegister;
    public TextField user, userF, txtSearch, userR;
    public TextArea txtPost;
    public ListView<String> infoPost;
    public String userLog;
    public ComboBox<String> typeR;

    public void initialize() {
        typeR.getItems().addAll("Facebook", "Twitter");
    }

    public void btn_log() {
        String user_name = user.getText();
        userLog = user_name;
        buscar(user_name);
    }

    public void OnBtn_logClicked() {
        btn_log();
        login.setVisible(false);
        redSocial.setVisible(true);
    }

    public void btnRegister() {
       login.setVisible(false);
       register.setVisible(true);
    }

    public void OnBtnRegisterClicked() {
        btnRegister();
    }

    public void btnR() {
        String user_name = userR.getText();
        String type = typeR.getValue();
        agregarCuenta(user_name, type);
    }

    public void OnBtnRClicked() {
        btnR();
        register.setVisible(false);
        login.setVisible(true);
    }

    public void addFriend() {
        String user_name = userF.getText();
        if (agregarAmigo(user_name, userLog)) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Agregar amigo");
            alert.setHeaderText("Amigo agregado");
            alert.setContentText("El amigo " + user_name + " ha sido agregado");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Agregar amigo");
            alert.setHeaderText("Error");
            alert.setContentText("El amigo " + user_name + " no ha sido agregado");
            alert.showAndWait();
        }
    }

    public void OnaddFriendClicked() {
        addFriend();
    }

    public void post() {
        String post_text = txtPost.getText();
        if (!UberSocial.agregarPost(post_text, userLog)) {
            agregarComment(userLog,0, userLog, post_text);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Agregar post");
            alert.setHeaderText("Post agregado");
            alert.setContentText("El post ha sido agregado");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Agregar post");
            alert.setHeaderText("Error");
            alert.setContentText("El post no ha sido agregado");
            alert.showAndWait();
        }
    }

    public void OnpostClicked() {
        post();
    }

    public void search() {
        String user_name = txtSearch.getText();
        buscar(user_name);
    }

    public void OnsearchClicked() {
        search();
    }

    public void btnShow() {
        infoPost.getItems().addAll(profileForm(userLog));
    }

    public void OnbtnShowClicked() {
        btnShow();
    }
}