package cz.cvut.ass.trafficlightcommandpattern;

public class Green implements State {

    private TrafficLight trafficLight;

    public Green(TrafficLight trafficLight) {
        this.trafficLight = trafficLight;
    }

    public boolean isOpen() {
        return true;
    }

    public void tick() {
        int count = 2;
        try {
            while (count != 0) {
                Thread.sleep(1000);
                System.out.format("%s: Tick (%s to finish)%n", this.getClass().getSimpleName(), count);
                count--;
            }
            trafficLight.setState(trafficLight.getOrange());
            trafficLight.setPrevious(trafficLight.getGreen());
            trafficLight.tick();
        } catch (InterruptedException ex) {
            System.err.println("An error occured :" + ex);
        }
    }
}
