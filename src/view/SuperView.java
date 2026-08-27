package view;

import java.io.IOException;

public class SuperView {
    public void loading(){
        for (int i = 0; i < 16; i++) {

            clearConsole();

            System.out.println();
            System.out.println("              로딩 중...");
            System.out.println();

            if (i % 4 == 0) {

                System.out.println("              ●●●●●");
                System.out.println("           ●●       ○○");
                System.out.println("         ●             ○");
                System.out.println("        ○               ○");
                System.out.println("        ○               ○");
                System.out.println("         ○             ○");
                System.out.println("           ○○       ○○");
                System.out.println("              ○○○○○");

            } else if (i % 4 == 1) {

                System.out.println("              ○○●●●");
                System.out.println("           ○○       ●●");
                System.out.println("         ○             ●");
                System.out.println("        ○               ○");
                System.out.println("        ○               ○");
                System.out.println("         ○             ○");
                System.out.println("           ○○       ○○");
                System.out.println("              ○○○○○");

            } else if (i % 4 == 2) {

                System.out.println("              ○○○○○");
                System.out.println("           ○○       ●●");
                System.out.println("         ○             ●");
                System.out.println("        ○               ●");
                System.out.println("        ○               ●");
                System.out.println("         ○             ○");
                System.out.println("           ○○       ○○");
                System.out.println("              ○○○○○");

            } else {

                System.out.println("              ○○○○○");
                System.out.println("           ○○       ○○");
                System.out.println("         ○             ○");
                System.out.println("        ○               ○");
                System.out.println("        ●               ○");
                System.out.println("         ●             ○");
                System.out.println("           ●●       ○○");
                System.out.println("              ●●●○○");
            }

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        clearConsole();

        System.out.println();
        System.out.println("              로딩 완료!");
    

    } // loading end

public static void clearConsole() {

        try {
            // System 클래스 자바에서 시스템 관련 기능을 가지고 있는 클래스
            // .getProperty : 현재 자바가 실행되고 있는 환경의 정보를 가져오는 메소드
            if (System.getProperty("os.name").contains("Windows")) {


                // ProcessBuilder : 외부 프로그램이나 운영체제 명령어를 실행하기 위한 클래스
                // cmd를 열고 /c : 뒤에오는 명령어를 실행한뒤 종료하라는 뜻. cls : 콘솔을 비움
                new ProcessBuilder("cmd", "/c", "cls")
                        .inheritIO()            // .inheritIO( ) 새로 실행되는 CMD창을  현재 자바가 실행하는 콘솔을 그대로 사용하게 하는 기능
                        .start()                // .start( )  실제로 프로세스를 실행하는 메소드
                        .waitFor();             //  .waitFor  실행할 프로세스가 끝날 때까지 기다리는 메소드 
                        // cls 실행 -> cls 끝날 때까지 대기 -> 다음 자바 코드 실행

            } else {
                //  나머지 운영체제인 리눅스나 맥에서는 보통 clear를 사용함. 
                new ProcessBuilder("clear")
                        .inheritIO()
                        .start()
                        .waitFor();
            }

        }catch (IOException e) {   // 파일 입출력에 관련된 오류

        System.out.println("콘솔 명령어를 실행할 수 없습니다.");

    } catch (InterruptedException e) {    
    // waitFor  : 기다리고 있는 java 스레드가 중간에 interrupt(중단된)를 당할 수 있기 떄문에 예외처리를 해야함.

        System.out.println("콘솔 명령어 실행 도중 대기가 중단되었습니다.");

        Thread.currentThread().interrupt();  // interrupt 상태 = true 로 
        //  현재 이 코드를 실행하고 있는 스레드 객체를 가져와서 interrupt 상태 표시
    }catch(Exception e){ System.out.println( e );}
}

} //  class end
