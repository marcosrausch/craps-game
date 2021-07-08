/*
Un jugador tira dos dados. Cada dado tiene seis caras, las cuales contienen uno, dos, tres cuatro, cinco y seis puntos negros, respectivamente. Una vez que los dados dejan de moverse, se calcula la suma de los puntos negros en las dos caras superiores. Si la suma es 7 u 11 en el primer tiro, el jugador gana. Si la suma es 2, 3 o 12 en el primer tiro (llamado “craps”), el jugador pierde (es decir, la “casa” gana). Si la suma es 4, 5, 6, 8, 9 o 10 en el primer tiro, esta suma se convierte en el “punto” del jugador. Para ganar, el jugador debe seguir tirando los dados hasta que salga otra vez “su punto” (es decir, que tire ese mismo valor de punto). El jugador pierde si tira un 7 antes de llegar a su punto
* */

import java.util.Random;

public class Craps {

    private Random random = new Random();
    private enum Partial { AGAIN, WON, LOST };
    private final static int ONES_TWOS = 2;
    private final static int THREE = 3;
    private final static int SEVEN = 7;
    private final static int ELEVEN = 11;
    private final static int TWELVE = 12;

    public void play() {

        int point = 0;
        Partial game;
        int diceSummary = rollDice();

        switch (diceSummary) {
            case SEVEN:
            case ELEVEN:
                game = Partial.WON;
                break;
            case ONES_TWOS:
            case THREE:
            case TWELVE:
                game = Partial.LOST;
                break;
           default:
                game = Partial.AGAIN;
                point = diceSummary;
                System.out.printf("Points are %d\n", point);
                break;
        }

        while (game == Partial.AGAIN) {
            diceSummary = rollDice();

            if (diceSummary == point) {
                game = Partial.WON;
            } else if (diceSummary == SEVEN) {
                game = Partial.LOST;
            }
        }

        if (game == Partial.WON) {
            System.out.println("Player won");
        } else {
            System.out.println("Player lost");
        }
    }

    public int rollDice() {
        int die1 = 1 + random.nextInt(6);
        int die2 = 1 + random.nextInt(6);

        int sum = die1 + die2;

        System.out.printf("player threw %d + %d = %d\n", die1, die2, sum);

        return sum;
    }

}
