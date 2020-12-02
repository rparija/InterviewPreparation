package java8practice;

public class Weather {

	float temperature;
	String cityName;
	Integer humidity;
	String desc;
	public float getTemperature() {
		return temperature;
	}
	public void setTemperature(float temperature) {
		this.temperature = temperature;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public Integer getHumidity() {
		return humidity;
	}
	@Override
	public String toString() {
		return "Weather [temperature=" + temperature + ", cityName=" + cityName + ", humidity=" + humidity + ", desc="
				+ desc + "]";
	}
	public void setHumidity(Integer humidity) {
		humidity = humidity;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		desc = desc;
	}
	public Weather(float temperature, String cityName, Integer humidity, String desc) {
		super();
		this.temperature = temperature;
		this.cityName = cityName;
		this.humidity = humidity;
		this.desc = desc;
	}
}
