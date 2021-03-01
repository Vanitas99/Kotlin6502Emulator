package KotlinEmulator
/*
    http://www.obelisk.me.uk/6502
 */
@kotlin.ExperimentalUnsignedTypes
typealias Word = UShort

// could also be companion object of class 6502Cpu
object Flags {
    val CARRY = 0x04
    val ZERO = 0x20
    val INTERRUPT_DISABLE = 0x10
    val DECIMAL_MODE = 0x8
    val BREAK_COMMAND = 0x4
    val OVERFLOW = 0x2
    val NEGATIVE = 0x1
}

class Mem {
    companion object {
        val MAX_MEM: Int = 1024*64;
    }
    var data: ByteArray = ByteArray(MAX_MEM)

    fun initialize() {
        data = ByteArray(MAX_MEM)
    }
}

class Cpu() {
    @kotlin.ExperimentalUnsignedTypes
    var PC: Word = 0u// Programm Counter
    @kotlin.ExperimentalUnsignedTypes
    var SP: Word = 0u// Stack Pointer

    // registers
    var A: Byte = 0x0
    var X: Byte = 0x0
    var Y: Byte = 0x0

    // Processor status register
    var PS: Byte = 0x0

    // memory
    var mem: Mem = Mem()

    // simple reset routine
    fun Reset() {
        PC = 0xFFFCu
        SP = 0x0100u
        PS = 0x0
        mem.initialize()
    }

    fun Execute() {

    }
}

fun main(args: Array<String>) {
    var cpu = Cpu()
    cpu.Reset()
    cpu.Execute()
}
