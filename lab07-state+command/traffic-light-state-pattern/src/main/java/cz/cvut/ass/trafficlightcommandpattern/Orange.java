package cz.cvut.ass.trafficlightcommandpattern;

public class Orange implements State {

    private TrafficLight trafficLight;

    public Orange(TrafficLight trafficLight) {
        this.trafficLight = trafficLight;
    }

    public boolean isOpen() {
        return false;
    }

    public void tick() {
        int count = 1;
        try {
            while (count != 0) {
                Thread.sleep(1000);
                System.out.format("%s: Tick (%s to finish)%n", this.getClass().getSimpleName(), count);
                count--;
            }
            if (trafficLight.getPrevious() == trafficLight.getGreen()) {
                trafficLight.setState(trafficLight.getRed());
            } else {
                trafficLight.setState(trafficLight.getGreen());
            }
            trafficLight.tick();
        } catch (InterruptedException ex) {
            System.err.println("An error occured :" + ex);
        }
    }
}
