package cz.cvut.ass.trafficlightcommandpattern;

public class Red implements State {

    private TrafficLight trafficLight;

    public Red(TrafficLight trafficLight) {
        this.trafficLight = trafficLight;
    }

    public boolean isOpen() {
        return false;
    }

    public void tick() {
        int count = 5;
        try {
            while (count != 0) {
                Thread.sleep(1000);
                System.out.format("%s: Tick (%s to finish)%n", this.getClass().getSimpleName(), count);
                count--;
            }
            trafficLight.setState(trafficLight.getOrange());
            trafficLight.setPrevious(trafficLight.getRed());
            trafficLight.tick();
        } catch (InterruptedException ex) {
            System.err.println("An error occured :" + ex);
        }
    }
}
