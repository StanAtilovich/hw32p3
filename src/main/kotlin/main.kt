val MASTERCARDorMAESTRO = "Master card or Maestro"
val VISAorMIR = "Visa or Mir"
val VKpay = "VK pay"

val CARDLIMIT = 150_000_00
val CARDLIMITMOUNTH = 600_000_00
val VISAorMIRcommission = 35_00
val VKpayMOUNTH = 40_000_00



fun commissionMastercardORmaestro(monthTrasaction: Long, allMounthTrassaction: Long): String {
    var count = ((monthTrasaction / 100 * 0.6) + 20_00).toInt()
    if (allMounthTrassaction >= CARDLIMITMOUNTH) {
        return "лимит за месяц исчерпан, мастер кард или маестро"
    } else if (monthTrasaction >= CARDLIMIT) {
        return "лимит за день исчерпан, мастер кард или маестро"
    } else if (monthTrasaction in 300_00..75_000_00) {
        return "коммиссия 0 копеек, мастер кард или маестро"
    } else {
        return "коммисия $count копеек, мастер кард или маестро"
    }
}

fun commissionVISAorMIR(monthTrasaction: Long, allMounthTrassaction: Long): String {
    var count = ((monthTrasaction / 100 * 0.75).toInt())
    if (allMounthTrassaction >= CARDLIMITMOUNTH) {
        return "лимит за месяц исчерпан, виза или мир"
    } else if (monthTrasaction >= CARDLIMIT) {
        return "лимит за день исчерпан, виза или мир"
    } else if (count <= VISAorMIRcommission) {
        return "коммиссия 3500коп, виза или мир"
    } else {
        return "коммиссия составляет $count коппеек, виза или мир"
    }
}
fun commisionVKpay(monthTrasaction: Long, allMounthTrassaction: Long): String {
    if (allMounthTrassaction >= VKpayMOUNTH) {
        return "лимит за месяц исчерпан, вк пай"
    } else if (monthTrasaction >= CARDLIMIT) {
        return "лимит за день исчерпан, вк пай"
    } else {
        return "комиссия 0 коп, вк пай"
    }
}

fun commission(
    typeCard: String = VKpay,
    monthTrasaction: Long,
    allMounthTrassaction: Long = 0
): String {
    return when (typeCard) {
        MASTERCARDorMAESTRO -> commissionMastercardORmaestro(monthTrasaction, allMounthTrassaction)
        VISAorMIR -> commissionVISAorMIR(monthTrasaction, allMounthTrassaction)
        else -> commisionVKpay(monthTrasaction, allMounthTrassaction)
    }
}


fun main() {
    println(commission(MASTERCARDorMAESTRO, 7_000, 8_000))
    println(commission(VISAorMIR, 55_000_00, 500_000_00))
    println(commission(VKpay, 80_000_00, 250_000_00))
}

