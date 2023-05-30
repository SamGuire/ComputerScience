class Primitives {
	public static void main(String[] args) {
		System.out.println("#########################  MIN-MAX OF DATATYPES #########################");
		System.out.printf("Min and Max for byte [%d,%d]\n",Byte.MIN_VALUE,Byte.MAX_VALUE);
		System.out.printf("Min and Max for short [%d,%d]\n",Short.MIN_VALUE,Short.MAX_VALUE);
		System.out.printf("Min and Max for int [%d,%d]\n",Integer.MIN_VALUE,Integer.MAX_VALUE);
		System.out.printf("Min and Max for long [%d,%d]\n",Long.MIN_VALUE,Long.MAX_VALUE);
		System.out.printf("Min and Max for double [%s,%s]\n",Double.MIN_VALUE,Double.MAX_VALUE);
		System.out.printf("Min and Max for float [%s,%s]\n",Float.MIN_VALUE,Float.MAX_VALUE);
		System.out.println("#########################################################################");
		System.out.println();

		/**
		 * 5.6.1. Unary Numeric Promotion
		 *
		 * Some operators apply unary numeric promotion to a single operand, which must produce a value of a numeric type:
		 *
		 *     If the operand is of compile-time type Byte, Short, Character, or Integer, it is subjected to unboxing conversion (§5.1.8). The result is then promoted to a value of type int by a widening primitive conversion (§5.1.2) or an identity conversion (§5.1.1).
		 *
		 *     Otherwise, if the operand is of compile-time type Long, Float, or Double, it is subjected to unboxing conversion (§5.1.8).
		 *
		 *     Otherwise, if the operand is of compile-time type byte, short, or char, it is promoted to a value of type int by a widening primitive conversion (§5.1.2).
		 *
		 *     Otherwise, a unary numeric operand remains as is and is not converted.
		 */
		System.out.println("#########################  WHAT HAPPENS IF ADD TOO MUCH (OVERFLOW) ? #########################");
		System.out.printf("Min and Max for byte [%d,%d]\n",Byte.MIN_VALUE-1,Byte.MAX_VALUE+1);
		System.out.printf("Min and Max for short [%d,%d]\n",Short.MIN_VALUE-1,Short.MAX_VALUE+1);
		System.out.printf("Min and Max for int [%d,%d]\n",Integer.MIN_VALUE-1,Integer.MAX_VALUE+1);
		System.out.printf("Min and Max for int [%d,%d]\n",Long.MIN_VALUE-1,Long.MAX_VALUE+1);
		System.out.printf("Min and Max for double [%s,%s]\n",Double.MIN_VALUE-1,Double.MAX_VALUE+1);
		System.out.printf("Min and Max for float [%s,%s]\n",Float.MIN_VALUE-1,Float.MAX_VALUE+1);
		System.out.println("#########################################################################");
		System.out.println();

	}
}
