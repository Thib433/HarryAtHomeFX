module com.example.harryathomefx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.almasb.fxgl.all;
    requires jdk.internal.le;

    opens com.example.harryathomefx to javafx.fxml;
    exports com.example.harryathomefx;
}