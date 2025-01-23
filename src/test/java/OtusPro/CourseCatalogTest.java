package OtusPro;

import extensions.UIExtensions;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.CourseCatalogPage;

import java.util.Map;


@ExtendWith(UIExtensions.class)
public class CourseCatalogTest {

  @Inject
  private CourseCatalogPage courseCatalogPage;

  @Test
  public void testSearchAndOpenCourseByName() {
    String courseName = "Нагрузочное тестирование";

    courseCatalogPage.open()
        .searchForCourse(courseName)
        .findAndClickCourseByName(courseName)
        .pageHeaderShouldBeSameAs(courseName);
  }

  @Test
  public void testFindAndCheckEarliestAndLatestCourses() {
    courseCatalogPage.open()
        .clickShowMoreButtonUntilAllLoaded()
        .findCoursesWithEarliestAndLatestDates()
        .verifyCoursesOnLinks();
  }
}
