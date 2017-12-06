package moe.feng.konachan.util

import java.util.Arrays
import java.util.Random

/**
 * @author amulya
 * @datetime 14 Oct 2014, 5:20 PM
 */
class ColorGenerator private constructor(private val mColors: List<Int>) {

	private val mRandom: Random = Random(System.currentTimeMillis())

	val randomColor: Int get() = mColors[mRandom.nextInt(mColors.size)]

	fun getColor(key: Any): Int {
		return mColors[Math.abs(key.hashCode()) % mColors.size]
	}

	companion object {

		@JvmStatic val DEFAULT: ColorGenerator = create(Arrays.asList(
				-0xe9c9c,
				-0xa7aa7,
				-0x65bc2,
				-0x1b39d2,
				-0x98408c,
				-0xa65d42,
				-0xdf6c33,
				-0x529d59,
				-0x7fa87f
		))

		@JvmStatic val MATERIAL: ColorGenerator = create(Arrays.asList(
				-0x1a8c8d,
				-0xf9d6e,
				-0x459738,
				-0x6a8a33,
				-0x867935,
				-0x9b4a0a,
				-0xb03c09,
				-0xb22f1f,
				-0xb24954,
				-0x7e387c,
				-0x512a7f,
				-0x759b,
				-0x2b1ea9,
				-0x2ab1,
				-0x48b3,
				-0x5e7781,
				-0x6f5b52
		))

		@JvmStatic fun create(colorList: List<Int>): ColorGenerator {
			return ColorGenerator(colorList)
		}
	}
}
