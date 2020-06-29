package PageObjects;

public class Weather {
	
	private int humidity;
	private int temperature;
	
	
	public Weather(int humidity, int temperature) {
		super();
		this.humidity = humidity;
		this.temperature = temperature;
	}


	public int getHumidity() {
		return humidity;
	}


	public int getTemperature() {
		return temperature;
	}



	

}
