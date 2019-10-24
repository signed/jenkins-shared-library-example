import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy

// this annotation is just there to make the ide happy.
// At runtime this comes from the pipeline environment
@Retention(RetentionPolicy.SOURCE)
@interface Library {
    String value()
}
