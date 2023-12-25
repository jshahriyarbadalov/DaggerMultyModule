#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring JNICALL
Java_com_shahriyar_core_1network_1api_CoreNetworkApi_stringFromJNI(
        JNIEnv* env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}