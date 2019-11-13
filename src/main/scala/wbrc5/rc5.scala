package wbrc5

import chisel3._
import chisel3.util._
import chisel3.experimental._
import chisel3.Driver

val Rc5Freq = 36000

// module to generate 36kHz clock
class Rc5Clock (val mainFreq: Int,
                val maxPerCount: Int = 14) extends Module {
    assert(mainFreq > 2*Rc5Freq, "Main frequency too low")
    val io = IO(new Bundle{
      val rc = Output(Bool())
      val rc_rise = Output(Bool())
      val rc_fall = Output(Bool())
      val per_count = Output(UInt(log2Ceil(maxPerCount+1).W))
      val enable = Input(Bool())
    }
}
