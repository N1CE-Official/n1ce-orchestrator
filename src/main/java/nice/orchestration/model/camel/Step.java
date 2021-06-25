package nice.orchestration.model.camel;

import java.util.Comparator;

public class Step  implements Comparator<Step>{

	private int position;
	private String route;
	
	public static final Comparator<Step> ASCENDING_COMPARATOR = 
		    Comparator.comparingInt(Step::getPosition);
	
	
	public Step() {}

	public Step(int position, String route) {
		super();
		this.position = position;
		this.route = route;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	@Override
	public String toString() {
		return "Step [position=" + position + ", route=" + route + "]";
	}

	@Override
	public int compare(Step arg0, Step arg1) {
		return ASCENDING_COMPARATOR.compare(arg0, arg1);
	}

	
	
}
