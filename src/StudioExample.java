import java.util.Arrays;
import java.util.List;

public class StudioExample {
    public static void main(String[] args) {
        List<Playable> list = Arrays.asList(new DvdPlayer(), new CdPlayer(), new TapePlayer(), new CdPlayer());

        for (Playable player : list) {
            System.out.println(player.play());
            System.out.println(player.pause());
            System.out.println(player.stop());
            System.out.println(player.reverse());

            if (player instanceof Recordable) {
                Recordable recorder = (Recordable) player;
                System.out.println(recorder.record());
            }
        }

    }

    static interface Playable {
        String play();
        String pause();
        String stop();
        String reverse();
    }

    static interface Recordable extends Playable {
        String record();
    }

    static class DvdPlayer implements Playable {
        @Override
        public String play() {
            return this.getClass().getName() + " plays";
        }

        @Override
        public String pause() {
            return this.getClass().getName() + " pauses";
        }

        @Override
        public String stop() {
            return this.getClass().getName() + " stops";
        }

        @Override
        public String reverse() {
            return this.getClass().getName() + " reverses";
        }
    }

    static class CdPlayer implements Playable {
        @Override
        public String play() {
            return this.getClass().getName() + " plays";
        }

        @Override
        public String pause() {
            return this.getClass().getName() + " pauses";
        }

        @Override
        public String stop() {
            return this.getClass().getName() + " stops";
        }

        @Override
        public String reverse() {
            return this.getClass().getName() + " reverses";
        }
    }

    static class TapePlayer implements Recordable {
        @Override
        public String play() {
            return this.getClass().getName() + " plays";
        }

        @Override
        public String pause() {
            return this.getClass().getName() + " pauses";
        }

        @Override
        public String stop() {
            return this.getClass().getName() + " stops";
        }

        @Override
        public String reverse() {
            return this.getClass().getName() + " reverses";
        }

        @Override
        public String record() {
            return this.getClass().getName() + " records";
        }
    }
}
