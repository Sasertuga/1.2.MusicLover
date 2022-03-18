const val DISCOUNT = 100.0
const val DISCOUNT_START = 1000
const val BIG_DISCOUNT_start = 10_000
const val BIG_DISCOUNT = 5 //%
const val MUSIC_LOVER_DISCOUNT = 1 //%

fun main() {
    println(
        "Вы меломан?)\n" +
                " Если ДА введите: 1\n" +
                " Eсли НЕТ введите: 2"
    )
    val inputQuestion = readLine()?.toInt() ?: return

    print("Введите сумму покупок: ")
    val input = readLine()?.toInt() ?: return

    var finalCheck = 0.0

    if (inputQuestion == 2) {
        if (input in (DISCOUNT_START)..BIG_DISCOUNT_start) {
            finalCheck = input - DISCOUNT

            println("покупка - $input рублей")
            print("после применения $DISCOUNT руб. скидки - $finalCheck рублей")

        } else if (input > BIG_DISCOUNT_start) {
            val priceInPercent = 100 - BIG_DISCOUNT
            finalCheck = priceInPercent * input.toDouble() / 100

            println("покупка - $input рублей")
            print("после применения $BIG_DISCOUNT% скидки - $finalCheck рублей")

        } else println("покупка - $input рублей")

    } else if (input in (DISCOUNT_START) until BIG_DISCOUNT_start) {
        finalCheck = input - DISCOUNT
        val value = finalCheck / 100 * MUSIC_LOVER_DISCOUNT
        finalCheck -= value


        println("покупка - $input рублей")
        print("после применения $MUSIC_LOVER_DISCOUNT% скидки - $finalCheck рублей")

    } else if (input > BIG_DISCOUNT_start) {
        val priceInPercent = 100 - BIG_DISCOUNT
        finalCheck = priceInPercent * input.toDouble() / 100
        val value = finalCheck / 100 * MUSIC_LOVER_DISCOUNT
        val finalCheckMusicLover = finalCheck - value

        println("покупка - $input рублей")
        println("после применения $BIG_DISCOUNT% скидки - $finalCheck рублей")
        print("после применения $MUSIC_LOVER_DISCOUNT% скидки - $finalCheckMusicLover рублей")

    } else {
        finalCheck = input.toDouble()
        val value = finalCheck / 100 * MUSIC_LOVER_DISCOUNT
        finalCheck -= value

        print("после применения $MUSIC_LOVER_DISCOUNT% скидки - $finalCheck рублей")
    }
}
