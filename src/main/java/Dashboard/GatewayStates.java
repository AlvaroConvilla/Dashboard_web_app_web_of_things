package Dashboard;


public class GatewayStates {

    private String weatherStation;
    private String Dome;
    private String Mount;
    private String CameraDMK;
    private String CameraIN;
    private String CameraOUT;

    public GatewayStates(){}

    public GatewayStates(String weatherStation, String Dome, String Mount, String CameraDMK, String CameraIN, String CameraOUT) {
        this.weatherStation = weatherStation;
        this.Dome = Dome;
        this.Mount = Mount;
        this.CameraDMK = CameraDMK;
        this.CameraIN = CameraIN;
        this.CameraOUT = CameraOUT;
    }

    public String getweatherStation() {
        return weatherStation;
    }
    public void setweatherStation(String weatherStation) {
        this.weatherStation = weatherStation;
    }

    public String getDome() {
        return Dome;
    }
    public void setDome(String Dome) {
        this.Dome = Dome;
    }

    public String getMount() {
        return Mount;
    }
    public void setMount(String Mount) {
        this.Mount = Mount;
    }

    public String getCameraDMK() {
        return CameraDMK;
    }
    public void setCameraDMK(String CameraDMK) {
        this.CameraDMK = CameraDMK;
    }

    public String getCameraIN() {
        return CameraIN;
    }
    public void setCameraIN(String CameraIN) {
        this.CameraIN = CameraIN;
    }

    public String getCameraOUT() {
        return CameraOUT;
    }
    public void setCameraOUT(String CameraOUT) {
        this.CameraOUT = CameraOUT;
    }
}
