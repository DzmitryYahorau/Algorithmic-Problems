package bitmanipulation

fun reverseBits(numb: Int): Int {
    var num: Int = numb
    var res = 0
    // traversing bits of 'num' from the right
    while (num > 0) {
        // bitwise left shift
        // 'res' by 1
        res = res.shl(1)     // multiply res by 2
        // if current bit is '1' or num is odd
        if ((num and 1) == 1) {
//            res ^= 1  // Convert 0 to 1
            res = res xor 1
        }
        // bitwise right shift
        // 'num' by 1
        num = num.shr(1)     // divide num by 2
    }
    // required number
    return res
}

fun main() {
    println(reverseBits(1210061376))
}
