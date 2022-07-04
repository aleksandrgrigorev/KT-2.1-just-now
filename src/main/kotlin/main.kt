fun main() {
    println("Сколько секунд назад пользователь был в сети?")
    val secondsCount = readln().toLong()

    println(agoToText(secondsCount, minutesAgo(secondsCount), hoursAgo(secondsCount)))
}

fun agoToText(secondsCount: Long, minutesAgo: String, hoursAgo: String): String = when {
    secondsCount < 0 -> "ошибка: отрицательное число"
    secondsCount <= 60 -> "был(а) только что"
    secondsCount <= 60 * 60 -> "был(а) $minutesAgo назад"
    secondsCount <= 24 * 60 * 60 -> "был(а) $hoursAgo назад"
    secondsCount <= 2 * 24 * 60 * 60 -> "был(а) сегодня"
    secondsCount <= 3 * 24 * 60 * 60 -> "был(а) вчера"
    else -> "был(а) давно"
}

fun minutesAgo(secondsCount: Long): String {
    val secondsPerMinute = 60
    val minutes: Long = secondsCount / secondsPerMinute
    val minutesStr = when {
        minutes.toString().endsWith("11") -> "$minutes минут"
        minutes.toString().endsWith("2") -> "$minutes минуты"
        minutes.toString().endsWith("1") -> "$minutes минуту"
        else -> "$minutes минут"
    }
    return minutesStr
}

fun hoursAgo(secondsCount: Long): String {
    val secondsPerHour = 3600
    val hours: Long = secondsCount / secondsPerHour
    val hoursStr = when {
        hours.toString().endsWith("11") -> "$hours часов"
        hours.toString().endsWith("12") -> "$hours часов"
        hours.toString().endsWith("13") -> "$hours часов"
        hours.toString().endsWith("14") -> "$hours часов"
        hours.toString().endsWith("1") -> "$hours час"
        hours.toString().endsWith("2") -> "$hours часа"
        hours.toString().endsWith("3") -> "$hours часа"
        hours.toString().endsWith("4") -> "$hours часа"
        else -> "$hours часов"
    }
    return hoursStr
}