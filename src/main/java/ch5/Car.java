public class Car {

  private String _manufacturer = "";
  private String _model = "";
  private int _year = -1;
  private String _licensePlate = "";

  public Car(String manufacturer, String model) {
    this._manufacturer = manufacturer;
    this._model = model;
  }

  public Car(String manufacturer, String model, int year) {
    this(manufacturer, model);
    this._year = year;
  }

  public Car(String manufacturer, String model, String licensePlate) {
    this(manufacturer, model);
    this._licensePlate = licensePlate;
  }

  public Car(String manufacturer, String model, String licensePlate, int year) {
    this(manufacturer, model);
    this._licensePlate = licensePlate;
    this._year = year;
  }

  public String manufacturer() { return _manufacturer; }
  public String model() { return _model; }
  public int year() { return _year; }
  public String licensePlate() { return _licensePlate; }
}