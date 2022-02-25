package com.example.redessociales;

import javafx.scene.control.Alert;

import java.util.ArrayList;

public class UberSocial {

    public static ArrayList<SocialClass> redesSociales = new ArrayList<>();
    public static Facebook facebook = new Facebook("");
    public static Twitter twitter = new Twitter("");

    public static SocialClass buscar(String user) {
        int indice = 0;
        return buscar(user, indice);
    }

    private static SocialClass buscar(String user, int indice) {
        if (indice < redesSociales.size()) {
            if (redesSociales.get(indice) instanceof Facebook) {
                Alert.AlertType alertType = Alert.AlertType.INFORMATION;
                Alert alert = new Alert(alertType);
                alert.setTitle("Facebook");
                alert.setHeaderText("Facebook");
                alert.setContentText("Facebook encontrado");
                alert.showAndWait();
                return redesSociales.get(indice);
            } else if (redesSociales.get(indice) instanceof Twitter) {
                Alert.AlertType alertType = Alert.AlertType.INFORMATION;
                Alert alert = new Alert(alertType);
                alert.setTitle("Twitter");
                alert.setHeaderText("Twitter");
                alert.setContentText("Twitter encontrado");
                alert.showAndWait();
                return redesSociales.get(indice);
            } else
                return buscar(user, indice + 1);
        }
        Alert.AlertType alertType = Alert.AlertType.ERROR;
        Alert alert = new Alert(alertType);
        alert.setTitle("Error");
        alert.setHeaderText("Error");
        alert.setContentText("El usuario no existe");
        return null;
    }


    public static void agregarCuenta(String user, String tipo) {
        SocialClass id = buscar(user);
        if (id != null) {
            Alert.AlertType alertType = Alert.AlertType.ERROR;
            Alert alert = new Alert(alertType);
            alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText("El usuario ya existe");
            alert.showAndWait();
        } else {
            if (tipo.equals("Facebook") && buscar(user) == null) {
                facebook = new Facebook(user);
                Alert.AlertType alertType = Alert.AlertType.INFORMATION;
                Alert alert = new Alert(alertType);
                alert.setTitle("Facebook");
                alert.setHeaderText("Facebook");
                alert.setContentText("Se ha agregado");
                alert.showAndWait();
            } else if (tipo.equals("Twitter") && buscar(user) == null) {
                twitter = new Twitter(user);
                Alert.AlertType alertType = Alert.AlertType.INFORMATION;
                Alert alert = new Alert(alertType);
                alert.setTitle("Twitter");
                alert.setHeaderText("Twitter");
                alert.setContentText("Se ha agregado");
            }
        }
    }


    public static boolean agregarPost(String user, String post) {
        SocialClass id = buscar(user);
        if (id != null) {
            id.post.add(post);
            Alert.AlertType alertType = Alert.AlertType.INFORMATION;
            Alert alert = new Alert(alertType);
            alert.setTitle("Post");
            alert.setHeaderText("Post");
            alert.setContentText("Post agregado");
            return true;
        } else {
            Alert.AlertType alertType = Alert.AlertType.ERROR;
            Alert alert = new Alert(alertType);
            alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText("El usuario no existe");
            return false;
        }
    }

    public static boolean agregarAmigo(String user1, String user2) {
        SocialClass id1 = buscar(user1);
        SocialClass id2 = buscar(user2);
        if (id1 != null && id2 != null) {
            if (id1 instanceof Facebook && id2 instanceof Facebook) {
                id2.addAmigo(user1);
                id1.addAmigo(user2);
                Alert.AlertType alertType = Alert.AlertType.INFORMATION;
                Alert alert = new Alert(alertType);
                alert.setTitle("Amigo");
                alert.setHeaderText("Amigo");
                alert.setContentText("Amigo agregado");
                return true;
            }
        } else {
            Alert.AlertType alertType = Alert.AlertType.ERROR;
            Alert alert = new Alert(alertType);
            alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText("Alguno de los usuarios no existe");
        }
        return false;
    }

    public static void agregarComment(String user, int postID, String autor, String comment) {
        SocialClass id1 = buscar(user);
        if (id1 != null) {
            if (id1 instanceof Facebook) {
                facebook.addComment(new Comment(postID, autor, comment));
                Alert.AlertType alertType = Alert.AlertType.INFORMATION;
                Alert alert = new Alert(alertType);
                alert.setTitle("Comentario");
                alert.setHeaderText("Comentario");
                alert.setContentText("Comentario agregado");
            }
        }
        System.out.println("No existe");

    }

    public static String profileForm(String user) {
        SocialClass id1 = buscar(user);
        if (id1 != null) {
            if (id1 instanceof Facebook) {
                id1.myProfile();
                Alert.AlertType alertType = Alert.AlertType.INFORMATION;
                Alert alert = new Alert(alertType);
                alert.setTitle("Perfil");
                alert.setHeaderText("Perfil");
                alert.setContentText("Perfil");
            } else if (id1 instanceof Twitter) {
                id1.myProfile();
                Alert.AlertType alertType = Alert.AlertType.INFORMATION;
                Alert alert = new Alert(alertType);
                alert.setTitle("Perfil");
                alert.setHeaderText("Perfil");
                alert.setContentText("Perfil");
            }
        }
        Alert.AlertType alertType = Alert.AlertType.ERROR;
        Alert alert = new Alert(alertType);
        alert.setTitle("Error");
        alert.setHeaderText("Error");
        alert.setContentText("El usuario no existe");
        return user;
    }

}

