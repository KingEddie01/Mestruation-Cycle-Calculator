package MentruationCycleApplication;

import javax.swing.*;
import java.time.LocalDate;
import java.util.Scanner;
public class MenstrualCheck {
    private static int cycleDuration;
    private static int periodDuration;

    private static LocalDate previousPeriodEndDate;
    private static String previousPeriodEndDateStr;
    static final  MenstrualCycle menstrualCycle = new MenstrualCycle();
    static final Scanner input = new Scanner(System.in);
    public static void display(String message) {
        JOptionPane.showMessageDialog(null, message);
    }
    public static String collectInput(String input) {
        return JOptionPane.showInputDialog(null, input);
    }


    public static void main(String[] args) {
        welcomeMessage();
    }

    public static void welcomeMessage() {
       display
                ("""    
                        CHEDDARS MENSTRUAL CALCULATOR \uD83C\uDF38!!!
                                        
                        Your personalized menstrual companion!
                        We're here to make your monthly journey easier, more predictable, and a little bit magical.
                        Say goodbye to guessing and hello to precision.
                        With Cheddars Menstrual App, you can effortlessly track your cycles, predict your next period.
                        Stay ahead of your fertile days.\s
                        We've got your back throughout your entire cycle.
                        Are you Ready to take control of your body?
                        Let's get started! \uD83C\uDF1F #PeriodPower\"""");

        System.out.println();
        periodStartDate();

    }
    public static void periodStartDate() {
        display("""
                \uD83C\uDF1F GET PERIOD START DATE \uD83C\uDF1F
                """);
        try {
            previousPeriodEndDateStr = collectInput("Enter the date of your last period (yyyy-MM-dd): ");
            previousPeriodEndDate = LocalDate.parse(previousPeriodEndDateStr);
            cycleDuration = Integer.parseInt(collectInput("Enter the average duration of your menstrual cycle (in days): "));
            display("Your flow is presumed to Start on : " + menstrualCycle.periodStartDate(previousPeriodEndDate, cycleDuration));
            display("""
                        Menstruation begins with the shedding of the uterine lining (endometrium).
                        Hormone levels, including estrogen and progesterone, are at their lowest.
                        Bleeding typically lasts for 3 to 7 days.
                        """);
                periodEndDate();
        }
        catch (IllegalArgumentException e) {
            display(e.getMessage());
            periodStartDate();
        }
    }

    public static void periodEndDate() {
        display("""
                \uD83C\uDF1F GET PERIOD END DATE \uD83C\uDF1F
                """);
        try {
            periodDuration = Integer.parseInt(collectInput("Enter period Duration (in days) : "));
            if (periodDuration <= 0) {
                display("Invalid period Duration");
                periodEndDate();
            }
            else {
                previousPeriodEndDate = LocalDate.parse(previousPeriodEndDateStr);
                display("your flow is presumed to end on  : " + menstrualCycle.periodEndDate(previousPeriodEndDate, periodDuration));
                display("""
                        The end of menstruation, often referred to as the "menstrual flow,"
                        marks the final phase of a woman's menstrual period.
                        This phase is characterized by the cessation of bleeding and other associated symptoms.
                        """);
                ovulationStartDate();
            }
        }
        catch (IllegalArgumentException e) {
            display(e.getMessage());
            periodEndDate();}

    }
    public static void ovulationStartDate(){
        display("""
                \uD83C\uDF1F GET OVULATION START DATE \uD83C\uDF1F
                """);
        try {
            display("your Ovulation is likely to  Starts on : " + menstrualCycle.ovulationStartDate(previousPeriodEndDate, cycleDuration));
            display("""
                    Around the middle of the cycle a surge in Luteinizing hormone
                    (LH)\s (LH) and a smaller surge in FSH trigger ovulation.
                    The mature follicle releases an egg into the fallopian tube.
                    This is the most fertile time, with the egg viable for about 12-24 hours.
                                        
                    SIGNS OF OVULATION:
                    Some women may experience physical and hormonal changes around the time of ovulation, including:
                                        
                    * Increased cervical mucus:
                        The mucus becomes thinner and more slippery to facilitate sperm movement.
                                        
                    * A mild increase in basal body temperature:
                        This can be tracked using a basal body temperature (BBT) chart.
                                        
                    * Mittelschmerz:
                            Some women may experience mild pelvic pain or twinges on one side of the lower abdomen.
                                        
                    * Increased libido:
                        Some women report heightened sexual desire during ovulation.
                    """);
            ovulationEndDate();
        }
        catch (IllegalArgumentException e) {
            display(e.getMessage());
            ovulationStartDate();
        }
    }

    public static void ovulationEndDate() {
        display("""
                \uD83C\uDF1F GET OVULATION END DATE \uD83C\uDF1F
                """);
        try {

            display("your Ovulation  is likely to stop on : " + menstrualCycle.ovulationEndDate(previousPeriodEndDate, cycleDuration));
            display("""
                    Ovulation is a relatively short event in a woman's menstrual cycle,
                    typically lasting around 12 to 24 hours.
                    Here are some details about the end of ovulation in a woman:
                    Return to Non-Fertile Phase:
                    After ovulation, if the egg is not fertilized,
                    the body transitions into the luteal phase of the menstrual cycle.
                    During this phase, the corpus luteum 
                    (a temporary endocrine structure formed from the ovarian follicle that released the egg) 
                    produces progesterone.
                    If pregnancy does not occur, the corpus luteum eventually breaks down, 
                    and progesterone levels decline,
                    leading to the shedding of the uterine lining in menstruation.
                    This marks the end of the menstrual cycle, and a new cycle begins.
                                         
                    It's important to remember that individual variations in menstrual cycles are common, 
                    and not all women have a regular %d-day cycle.
                    If you are trying to conceive or have concerns about your menstrual cycle,
                    it's advisable to track your cycle,
                    monitor ovulation signs, and consult a healthcare provider or a fertility specialist for 
                    personalized guidance.
                    """);
            firstSafePeriodStartDate();
        }
        catch (IllegalArgumentException e) {
            display(e.getMessage());
            ovulationEndDate();
        }
    }

    public static void firstSafePeriodStartDate() {
        display("""
                \uD83C\uDF1F GET FIRST SAFE WINDOW START DATE \uD83C\uDF1F
                """);
        try {
            display("The first safe windows are  : " + menstrualCycle.firstSafePeriodStartDate(previousPeriodEndDate, periodDuration, cycleDuration));
            display("""
                    The first safe period after menstruation, also known as the "post menstrual safe period,".
                    It is a time when a woman is less likely to conceive
                     because it occurs shortly after her menstrual period has ended.
                    This period is generally considered one of the safer times to have unprotected intercourse.
                     if a woman is using natural family planning methods for contraception.
                    However, it's important to understand that these methods are not foolproof,
                    and there is still a risk of pregnancy.
                    """);
            firstSafePeriodEndDate();
        } catch (IllegalArgumentException e) {
            display(e.getMessage());
            firstSafePeriodStartDate();
        }
    }

    public static void firstSafePeriodEndDate() {
        display("""
                \uD83C\uDF1F GET SAFE WINDOW END DATE \uD83C\uDF1F
                """);
        try {
            display("safe window ends on : " + menstrualCycle.firstSafePeriodEndDate(previousPeriodEndDate, cycleDuration));
            display("""
                    During the end of the safe period before ovulation,
                    a woman is transitioning from the phase immediately following her menstrual period to the fertile window,
                    which is when she is most likely to conceive if she has unprotected intercourse.\s
                    """);
            unSafePeriodStartDate();
        } catch (IllegalArgumentException e) {
            display(e.getMessage());
            firstSafePeriodEndDate();

        }
    }


    public static void unSafePeriodStartDate() {
        display("""
                \uD83C\uDF1F GET UNSAFE WINDOW START DATE \uD83C\uDF1F
               """);
        try {
            display("your unsafe window starts from : " + menstrualCycle.unSafePeriodStartDate(previousPeriodEndDate, cycleDuration, periodDuration));
            display("""
                    "Unsafe periods" typically refer to the fertile window in a woman's menstrual cycle
                     when she is at a higher risk of becoming pregnant if she engages in unprotected sexual intercourse.
                     During these unsafe periods, ovulation has occurred or is about to occur,
                     making it more likely for a sperm to fertilize an egg.\s
                    """);
            UnSafePeriodEndDate();
        }
        catch (IllegalArgumentException e) {
            display(e.getMessage());
            unSafePeriodStartDate();
        }
    }

    public static void UnSafePeriodEndDate() {
        display("""
                \uD83C\uDF1F GET UNSAFE WINDOW END DATE \uD83C\uDF1F
                """);
        try {
            display("your unsafe window ends on  : " + menstrualCycle.unSafePeriodEndDate(previousPeriodEndDate, cycleDuration));
            display("""
                    The "safe period" or "infertile period" after ovulation refers to the time
                    during a woman's menstrual cycle when the likelihood of conceiving a pregnancy is significantly reduced.
                    This period typically occurs after ovulation when the released egg is no longer viable,
                    and the fertile window has passed.
                    """);
            nextSafePeriodDate();
        }
        catch (IllegalArgumentException e) {
            display(e.getMessage());
            UnSafePeriodEndDate();
        }

    }
    public static void nextSafePeriodDate(){
        display("""
                \uD83C\uDF1F GET NEXT SAFE WINDOW  DATE \uD83C\uDF1F
                """);
        try {
            display("your next safe window starts from : " + menstrualCycle.nextSafePeriodDate(previousPeriodEndDate, cycleDuration, periodDuration));
            display("""
                    The "final safe period" before the next menstrual flow refers to
                    the days following ovulation when a woman is considered less likely to conceive
                    before her next period begins. This phase is typically seen as a lower-risk time for pregnancy
                    because ovulation has already occurred, and the egg is no longer available for fertilization. However,
                    it's important to remember that individual variations and cycle irregularities are not
                    can affect the accuracy of this method.\s
                    """);
            exit();
        }
        catch (IllegalArgumentException e) {
            display(e.getMessage());
            nextSafePeriodDate();
        }
    }

    public static void exit(){
        display("Thanks for using Cheddar Menstrual Calculator");
        String option = collectInput("""
                Select an option :
                1. Return to Main Menu
                0. Exit
                """);
        switch (option) {
            case "1" ->{welcomeMessage();}
            case "0" ->{display("GOODBYE");}
            default -> {display("Invalid input");
                    exit();
            }
        }
    }


    }


