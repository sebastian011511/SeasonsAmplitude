
/**
 * This program was created by Sebastian Vasco
 * Program reads an array of temperatures.  Temps are gather by season (Winter, Spring, Fall, Summer).
 * App allows will calc which season has highest amplitude and prints it out for you.
 * */

public class Seasons {

    public static void main(String[] args) {
        int[] T = {3, 1, 1, 4, 9844, 3, 56, 9, 3, 2, 4, 1};
        String test = Solution(T);

        /*for (int x=0;x<4;x++){
            array[x]=
        }*/
        System.out.println(test);
    }

    public static String Solution(int[] T) {

        //Default high and low
        int max = T[0];
        int min = T[0];

        int[] ampArray = new int[4]; //array will hold amps for each season
        int seasons = T.length / 4;

        int ampCounter = 0; //counter to assign max amps array
        int seasonCheck = 1; //helps if statement in loop below for separate seasons

        for (int counter = 0; counter < T.length; counter++) {

            if (T[counter] < min) //checks for lowest temp
                min = T[counter];

            else if (max < T[counter]) //checks for highest temp
                max = T[counter];

            if (seasonCheck % seasons == 0) { //Between seasons, reset lowest and highest
                ampArray[ampCounter] = max - min; //find amp and saves it to a new array

                if (T.length == counter + 1) { //out of bounds check
                    break;
                } else {
                    min = T[counter + 1]; //reassign max and min after amp is found for season
                    max = T[counter + 1];
                }
                ampCounter++;  //array index check
            }
            seasonCheck++; //Seasons check counter


        }

        int val = 0; //loop counter
        max = ampArray[0]; //default highest amp
        seasons = 0;

        //loop checks highest amp
        while (val < ampArray.length) {
            if (max < ampArray[val]) {
                seasons = val;
                max = ampArray[val];
            }
            val++;

        }

        String bigAmp = null; //holds biggest amp
        switch (seasons) {
            case 0:
                bigAmp = "WINTER";
                break;
            case 1:
                bigAmp = "SPRING";
                break;
            case 2:
                bigAmp = "SUMMER";
                break;
            case 3:
                bigAmp = "AUTUMN";
                break;

        }
        return bigAmp;
    }
}