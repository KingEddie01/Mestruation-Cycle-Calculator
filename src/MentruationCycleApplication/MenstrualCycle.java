package MentruationCycleApplication;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MenstrualCycle {
    private LocalDate periodStartDate;
    private LocalDate periodEndDate;
    private LocalDate ovulationStartDate;
    private LocalDate ovulationEndDate;
    private LocalDate nextSafePeriodDate;
    private final List<LocalDate> safePeriodsDate = new ArrayList<>();
    private LocalDate firstSafePeriodEndDate;
    private LocalDate unSafePeriodStartDate;
    private LocalDate unSafePeriodEndDate;





    public LocalDate periodStartDate(LocalDate previousPeriodEndDate, int cycleDuration) {
        periodStartDate = previousPeriodEndDate.plusDays(cycleDuration);
        return periodStartDate;
        }




    public LocalDate periodEndDate(LocalDate previousPeriodEndDate, int periodDuration) {
        if (previousPeriodEndDate != null) {
            LocalDate periodStartDate = previousPeriodEndDate.plusDays(periodDuration);
            periodEndDate = periodStartDate.plusDays(periodDuration);
            return periodEndDate;
        } else {
            throw new IllegalArgumentException("Previous period end date is null.");
        }
    }

    public LocalDate ovulationStartDate(LocalDate previousPeriodEndDate, int cycleDuration) {
        if (previousPeriodEndDate != null) {
            periodStartDate = previousPeriodEndDate.plusDays(cycleDuration);
            ovulationStartDate = periodStartDate.plusDays(cycleDuration / 2);
            return ovulationStartDate;
        } else {
            throw new IllegalArgumentException("Previous period end date is null.");
        }
    }

    public LocalDate ovulationEndDate(LocalDate previousPeriodEndDate, int cycleDuration) {
        if (previousPeriodEndDate != null) {
            periodStartDate = previousPeriodEndDate.plusDays(cycleDuration);
            ovulationStartDate = periodStartDate.plusDays(cycleDuration / 2);
            ovulationEndDate = ovulationStartDate.plusDays(1);
            return ovulationEndDate;
        } else {
            throw new IllegalArgumentException("Previous period end date is null.");
        }
    }

    public List<LocalDate> firstSafePeriodStartDate(LocalDate previousPeriodEndDate, int periodDuration, int cycleDuration) {
        if (previousPeriodEndDate != null) {
            periodStartDate = previousPeriodEndDate.plusDays(cycleDuration);
            LocalDate periodEndDate = periodStartDate.plusDays(periodDuration);
            int ovulationBegins = (cycleDuration / 2) - 2;
            if (periodDuration >= ovulationBegins) {
                throw new IllegalArgumentException("Invalid period duration.");
            }

            int count;
            for (count = periodDuration + 1; count < ovulationBegins; count++) {
                LocalDate safePeriod = periodEndDate.plusDays(count);
                safePeriodsDate.add(safePeriod);
            }
            return safePeriodsDate;
        } else {
            throw new IllegalArgumentException("Previous period end date is null.");
        }
    }

    public LocalDate firstSafePeriodEndDate(LocalDate previousPeriodEndDate, int cycleDuration) {
        if (previousPeriodEndDate != null) {
            periodStartDate = previousPeriodEndDate.plusDays(cycleDuration);
            ovulationStartDate = periodStartDate.plusDays(cycleDuration / 2);
            ovulationEndDate = ovulationStartDate.plusDays(1);
            firstSafePeriodEndDate = ovulationEndDate.plusDays(2);
            return firstSafePeriodEndDate;
        } else {
            throw new IllegalArgumentException("Previous period end date is null.");
        }
    }

    public LocalDate unSafePeriodStartDate(LocalDate previousPeriodEndDate, int cycleDuration, int periodDuration) {
        if (previousPeriodEndDate != null) {
            periodStartDate = previousPeriodEndDate.plusDays(cycleDuration);
            periodEndDate = periodStartDate.plusDays(periodDuration);
            unSafePeriodStartDate = periodEndDate.plusDays(cycleDuration / 4);
            return unSafePeriodStartDate;
        } else {
            throw new IllegalArgumentException("Previous period end date is null.");
        }
    }

    public LocalDate unSafePeriodEndDate(LocalDate previousPeriodEndDate, int cycleDuration) {
        if (previousPeriodEndDate != null) {
            periodStartDate = previousPeriodEndDate.plusDays(cycleDuration);
            ovulationStartDate = periodStartDate.plusDays(cycleDuration / 2);
            ovulationEndDate = ovulationStartDate.plusDays(1);
            unSafePeriodEndDate = ovulationEndDate.plusDays(2);
            return unSafePeriodEndDate;
        } else {
            throw new IllegalArgumentException("Previous period end date is null.");
        }
    }

    public List<LocalDate> nextSafePeriodDate(LocalDate previousPeriodEndDate, int cycleDuration, int periodDuration) {
        if (previousPeriodEndDate != null) {
            periodStartDate = previousPeriodEndDate.plusDays(cycleDuration);
            LocalDate periodEndDate = periodStartDate.plusDays(periodDuration);
            if (cycleDuration <= periodDuration + 11) {
                throw new IllegalArgumentException("Invalid cycle duration.");
            }

            int count;
            for (count = periodDuration + 11; count < cycleDuration; count++) {
                LocalDate safePeriod = periodEndDate.plusDays(count);
                safePeriodsDate.add(safePeriod);
            }
            return safePeriodsDate;
        } else {
            throw new IllegalArgumentException("Previous period end date is null.");
        }
    }

    }



