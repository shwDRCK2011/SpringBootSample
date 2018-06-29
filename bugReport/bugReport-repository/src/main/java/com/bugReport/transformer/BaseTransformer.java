
package com.bugReport.transformer;


public interface BaseTransformer<T, I> {

	I transform(T type);

	T reverseTransform(I type);
}
