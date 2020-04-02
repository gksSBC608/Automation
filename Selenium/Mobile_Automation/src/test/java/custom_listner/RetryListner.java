package custom_listner;

import java.lang.reflect.Constructor;


import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

import utilities.RetryUtility;

public class RetryListner implements IAnnotationTransformer {

   
    public void transform(ITestAnnotation testannotation, Class testClass,
                          Constructor testConstructor, Method testMethod){
        System.out.println("_*from retry listner*__");
        // This will re-trigger the failed test case
        IRetryAnalyzer retry = testannotation.getRetryAnalyzer();

        if (retry == null)	{
            System.out.println("_*from retry listner inside if*__");
            testannotation.setRetryAnalyzer(RetryUtility.class);
        }
        System.out.println("_*End of  retry listner*__");

    }

}
