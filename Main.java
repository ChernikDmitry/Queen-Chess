package com.company;

import static java.lang.System.currentTimeMillis;

public class Main {
    //метод распечатки трехмерного массива
    static void show_array(int[][][] array, int size){
        int size2= array[1].length;
        int size3= array[0][1].length;

        System.out.println();
        for (int a = 1; a <size+1; a++) {
            System.out.println("решение номер " + a);
            for (int i = size2 - 1; i > -1; i--) {
                for (int k = 0; k < size3; k++) {
                    System.out.print(array[a][i][k]+" ");
                }
                System.out.println();
            }
        }
    }

    //метод распечатки двумерного массива
    static void show_array(int[][] array){
        int size2= array.length;
        int size3= array[1].length;

        System.out.println();
        for (int i = size2 - 1; i > -1; i--) {
            for (int k = 0; k < size3; k++) {
                System.out.print(array[i][k]+" ");
            }
            System.out.println();
        }
    }

    //метод очистки двумерного массива
    static void clean_array(int[][] array){
        int size2= array.length;
        int size3= array[1].length;
        for (int i = 0; i < size2; i++) {
            for (int k = 0; k < size3; k++) {
                array[i][k] = 0;
            }
        }
    }

    //метод установки ферзя на поле chess
    static void queen_on(int[][] chess, int Qstr, int Qstb){
        int[][] pole=new int[8][8];
        for (int i = 0; i <= 7; i++) {
            pole[Qstr][i] = 1;
        }
        for (int i = 1; i <= Qstr; i++) {
            pole[Qstr - i][Qstb] = 1;
            if ((Qstb - i) > -1) pole[Qstr - i][Qstb - i] = 1;
            if ((Qstb + i) < 8) pole[Qstr - i][Qstb + i] = 1;
        }
        for (int i = 1; i < 8 - Qstr; i++) {
            pole[Qstr + i][Qstb] = 1;
            if ((Qstb - i) > -1) pole[Qstr + i][Qstb - i] = 1;
            if ((Qstb + i) < 8) pole[Qstr + i][Qstb + i] = 1;
        }

        for (int i = 0; i < 8; i++) {
            for (int k = 0; k < 8; k++) {
                chess[i][k] += pole[i][k];
            }
        }
    }

    //метод установки ферзя на поле chess как я думаю ускоренный
    static void queen_on_fast(int[][] chess, int Qstr, int Qstb, int [][][][] pole){

        for (int i = 0; i < 8; i++) {
            for (int k = 0; k < 8; k++) {
                chess[i][k] += pole[Qstr][Qstb][i][k];
            }
        }
    }



    public static void main(String[] args) {
//формируем массивы полей под боем для всех ферзей
        int Qstr;
        int Qstb;
        int[][][][] pole=new int[8][8][8][8];
        for(Qstb=0;Qstb<8;Qstb++) {
            for (Qstr = 0; Qstr < 8; Qstr++) {
                for (int i = 0; i <= 7; i++) {
                    pole[Qstr][Qstb][Qstr][i] = 1;
                }
                for (int i = 1; i <= Qstr; i++) {
                    pole[Qstr][Qstb][Qstr - i][Qstb] = 1;
                    if ((Qstb - i) > -1) pole[Qstr][Qstb][Qstr - i][Qstb - i] = 1;
                    if ((Qstb + i) < 8) pole[Qstr][Qstb][Qstr - i][Qstb + i] = 1;
                }
                for (int i = 1; i < 8 - Qstr; i++) {
                    pole[Qstr][Qstb][Qstr + i][Qstb] = 1;
                    if ((Qstb - i) > -1) pole[Qstr][Qstb][Qstr + i][Qstb - i] = 1;
                    if ((Qstb + i) < 8) pole[Qstr][Qstb][Qstr + i][Qstb + i] = 1;
                }
            }
        }
        int q1 = (int) currentTimeMillis();
        int[][] chess = new int[8][8];
        int sum = 0;
        int nomer = 0;
        boolean rasstanovka;

        //устанавливаем последовательно 1го ферзя на все клетки 1го столбца
        clean_array(chess);
        for (int i1 = 0; i1 <= 7; i1++) {
            //устанавливаем последовательно 2го ферзя на все клетки
            for (int i2 = 0; i2 <= 7; i2++) {
                if (i2!=i1) {
                    //устанавливаем последовательно 3го ферзя на все клетки
                    for (int i3 = 0; i3 <= 7; i3++) {
                        if (i3 != i2 && i3 != i1) {
                            //устанавливаем последовательно 4го ферзя на все клетки
                            for (int i4 = 0; i4 <= 7; i4++) {
                                if (i4 != i3 && i4 != i2 && i4 != i1) {
                                    //устанавливаем последовательно 5го ферзя на все клетки
                                    for (int i5 = 0; i5 <= 7; i5++) {
                                        if (i5 != i4 && i5 != i3 && i5 != i2 && i5 != i1) {
                                            //устанавливаем последовательно 6го ферзя на все клетки
                                            for (int i6 = 0; i6 <= 7; i6++) {
                                                if (i6 != i5 && i6 != i4 && i6 != i3 && i6 != i2 && i6 != i1) {
                                                    //устанавливаем последовательно 7го ферзя на все клетки
                                                    for (int i7 = 0; i7 <= 7; i7++) {
                                                        if (i7 != i6 && i7 != i5 && i7 != i4 && i7 != i3 && i7 != i2 && i7 != i1) {
                                                            //устанавливаем последовательно 8го ферзя на все клетки
                                                            for (int i8 = 0; i8 <= 7; i8++) {
                                                                if (i8 != i7 && i8 != i6 && i8 != i5 && i8 != i4 && i8 != i3 && i8 != i2 && i8 != i1) {
                                                                    queen_on_fast(chess, i1, 0, pole);
                                                                    queen_on_fast(chess, i2, 1, pole);
                                                                    queen_on_fast(chess, i3, 2, pole);
                                                                    queen_on_fast(chess, i4, 3, pole);
                                                                    queen_on_fast(chess, i5, 4, pole);
                                                                    queen_on_fast(chess, i6, 5, pole);
                                                                    queen_on_fast(chess, i7, 6, pole);
                                                                    queen_on_fast(chess, i8, 7, pole);
                                                                    if (chess[i1][0] == 1 &&
                                                                            chess[i2][1] == 1 &&
                                                                            chess[i3][2] == 1 &&
                                                                            chess[i4][3] == 1 &&
                                                                            chess[i5][4] == 1 &&
                                                                            chess[i6][5] == 1 &&
                                                                            chess[i7][6] == 1 &&
                                                                            chess[i8][7] == 1) {

                                                                        sum++;
                                                                        //System.out.println("решение номер " + sum);
                                                                        //show_array(queen);
                                                                    }
                                                                    nomer++;
                                                                    //System.out.println("попытка " + nomer+" "+i1+" "+sum );
                                                                    //show_array(chess);
                                                                    //show_array(queen);

                                                                    clean_array(chess);

                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

        }
        int q2 = (int) currentTimeMillis();
        int min=(q2-q1)/60000;
        int sec=(q2-q1)/1000%60;
        int msec=(q2-q1)%1000;

        System.out.println("всего попыток " + nomer+"; правильных решений"+sum );
        System.out.println("решение заняло " + min+" минут и "+sec+" секунд "+msec+" милисекунд" );
        variant_2 ();

    }





    static void variant_2 (){

        int q1 = (int) currentTimeMillis() ;
        //int[][] chess=new int[8][8];
        //добавляем ферзя на первую случайную пустую клетку
        int CHstr;
        int CHstb;
        int f;
        int nul;
        int[][] chess = new int[8][8];
        int[][] queen = new int[8][8];

        //определяем сколько раз будем решать
        int size=1000;
        //int[][] queen=new int[8][8];
        int[][][] result = new int[size][8][8];
        int t=0;

        for(int s = 1; s < size;s++) {
            f = 0;
            while (f < 8) {
                f = 0;
                nul = 64;
                // очистка массивов
                clean_array(chess);
                clean_array(queen);

                while (nul > 0) {
                    CHstr = (int) (Math.random() * 8);
                    CHstb = (int) (Math.random() * 8);
                    if (chess[CHstr][CHstb] == 0 && queen[CHstr][CHstb] == 0) {
                        queen[CHstr][CHstb] = 1;
                        f++;
                        // старый вариант установки ферзя
                        //for (int i = 0; i < 8; i++) {
                        //    for (int k = 0; k < 8; k++) {
                        //        chess[i][k] += pole[CHstr][CHstb][i][k];
                        //    }
                        //}
                        queen_on(chess,CHstr,CHstb);


                        //определяем кол-во свободных клеток
                        nul = 0;
                        for (int i = 0; i < 8; i++) {
                            for (int k = 0; k < 8; k++) {
                                if (chess[i][k] == 0) {
                                    nul++;
                                }
                            }
                        }


                    }
                }


            }
            //распечатать массив с решением
            //show_array(chess);




// сохраняем результат в массив result

            boolean state=true;
            int povtor =0;

            for (int a = 0; a < (t+1); a++) {
                state=true;
                for (int i = 0; i < 8; i++) {
                    for (int k = 0; k < 8; k++) {
                        if (result[a][i][k] != chess[i][k]) {
                            state = false;


                        }
                    }
                }
                if (state){
                    povtor++;
                    //System.out.println("найдено повторное решение "+povtor+", циклов:"+s);
                    break;
                }

            }

            if (!state) {
                //System.out.println("записываем решение "+(t+1));
                t++;
                for (int i = 0; i < 8; i++) {
                    for (int k = 0; k < 8; k++) {
                        result[t][i][k] = chess[i][k];
                    }
                }
                //System.out.println("сохранен " + t + "-ый результат");
            }
        }

//распечатать массив

        //show_array(result,t);
        int q2 = (int) currentTimeMillis();
        int min=(q2-q1)/60000;
        int sec=(q2-q1)/1000%60;
        int msec=(q2-q1)%1000;

        System.out.println("всего попыток " + t+"; правильных решений"+t );
        System.out.println("решение заняло " + min+" минут и "+sec+" секунд  "+msec+" милисекунд" );

    }
}
