import java.util.Scanner;

public class IdealNumber {

    /*
    Sorry, hab bemerkt, dass wir die echten Divisoren gar nicht ausgeben müssen.
    Das erleichtert das Programm natürlich um einiges!
     */

    public static void main(String[] args) {

        /*
            Ich hab die In Klasse nicht, die ihr bekommen habts.
            Darum hab ich Scanner verwendet, eine Klasse die mit Java kommt.
            Du kannst auch gleich machen:

            int inputNumber = In.readInt();

            Die do-while Schleife führt einmal das Codeinnere aus und wiederholt es
            so lange die untere Bedingung in der Klammer erfüllt ist, also solange der
            Nutzer immer eine Zahl <= 1 eingibt. Lt. Angabe ist 0 sowieso keine
            ideale Zahl, also muss inputNumber > 0 sein. Wir nehmen an, dass 0 auch keine
            natürliche Zahl, also ungültig zum Eingeben, ist.
         */
        int inputNumber;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Enter number: ");
            inputNumber = scanner.nextInt();
        }while(inputNumber <= 0);

        /*
            Die Aufgabenstellung verlang eigentlich nicht, dass wir die echten
            Divisoren speichern/ausgeben. Das Grundprinzip bleibt aber gleich:
            Für einen echten Divisor muss für inputNumber % i Rest = 0 rauskommen.
            Z.B.:

            6 % 0 --> rest = 0 -> KEIN TRUEDIVISOR: Durch 0 kann man nicht teilen!
            6 % 1 --> rest = 0 -> TRUEDIVISOR, Aber siehe unten (*)
            6 % 2 --> rest = 0 -> TRUEDIVISOR
            6 % 3 --> rest = 0 -> TRUEDIVISOR
            6 % 4 --> rest = 2 -> KEIN TRUEDIVISOR: Rest nicht 0
            6 % 5 --> rest = 1 -> KEIN TRUEDIVISOR: Rest nicht 0
            6 % 6 --> rest = 0 -> KEIN TRUEDIVISOR: Lt. Angabe zählt die Zahl selbst nicht.

            Falls nötig, nimm dir einen Stift und schreibe dir einmal alle relevanten
            Fälle so auf. Wenn du das machst, erkennst du, dass 2 und 3 die echten
            Divisoren sind.
         */

        /*
            i soll den Divisor darstellen, mit dem die inputNumber geteilt wird.
            Sie beginnt gleich bei 2, weil eine Teilung durch 0 sowieso nicht geht und
            durch 1 trivial ist.
         */
        int i = 2;

        /*
            (*) Die Angabe ist blöd geschrieben, weil eig. 1 ein echter Divisor ist.
            Die haben es aber eh berücksichtigt, weil zur Summe der echten Teiler
            plus 1 gerechnet wird. (Man kann also auch gleich sum mit 1 initialisieren,
            anstatt bei dem Check immer 1 dazuzurechnen). Nicht vergessen,
            sum muss gleich der inputNumber sein.
         */
        int sum = 1;

        while(i < inputNumber){        // solange i (=Divisor) kleiner als die Zahl ist
            if(inputNumber % i == 0){  // wenn es sich um einen echten Divisor handelt
                sum += i;              // i (also den Divisor) zur Summe addieren
            }                          // (ansonsten nichts machen)
            i++;                       // i (also den Divisor) um eins erhöhen
        }
        /*
            Am Ende der Schleife, also wenn wir mit allen Divisoren durch sind,
            schauen, ob nun sum gleich der inputNumber ist.

            Lt. Angabe ist 1 keine ideale Zahl, also machen wir eine zweite Bedingung
            mit && wo die inputNumber auch nicht 1 sein darf, ansonsten ist sie nicht ideal.
         */
        System.out.print("The number " + inputNumber);
        if(sum == inputNumber && inputNumber != 1){
            System.out.print(" is ideal.");
        } else {
            System.out.print(" is not ideal.");
        }
    }
}
