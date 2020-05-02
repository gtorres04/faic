package tv.codely.apps.backoffice.backend;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import tv.codely.apps.backoffice.backend.config.BackofficeBackendServerConfiguration;
import tv.codely.apps.backoffice.backend.config.BackofficeBackendServerPortCustomizer;
import tv.codely.apps.backoffice.backend.controller.courses.CoursesGetController;
import tv.codely.apps.backoffice.backend.controller.health_check.HealthCheckGetController;
import tv.codely.shared.application.CommandHandler;
import tv.codely.shared.domain.CaseOfUse;
import tv.codely.shared.domain.DomainService;
import tv.codely.shared.domain.Factory;
import tv.codely.shared.domain.Service;
import tv.codely.shared.infrastructure.Adapter;

import java.util.HashMap;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
//TODO cambiar la caonfiguracion
/*@ComponentScan(
    includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Service.class),
    value = {"tv.codely.shared", "tv.codely.backoffice", "tv.codely.apps.backoffice.backend"}
)*/
@ComponentScan(
    excludeFilters = {@ComponentScan.Filter(
        type = FilterType.ASSIGNABLE_TYPE, classes = {
        BackofficeBackendServerConfiguration.class,
        BackofficeBackendServerPortCustomizer.class,
        CoursesGetController.class,
        HealthCheckGetController.class
    })},
    includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {
        Service.class, CommandHandler.class, CaseOfUse.class, Adapter.class, DomainService.class,
        Factory.class
    }),
    value = {"tv.codely.shared.infrastructure.bus.command", "tv.codely.shared.infrastructure.bus.query", "tv.codely.shared.infrastructure.bus.event.spring", "tv.codely.backoffice.funds", "tv.codely.apps.backoffice.backend"}
)
public class BackofficeBackendApplication {
    public static HashMap<String, Class<?>> commands() {
        return new HashMap<String, Class<?>>() {{
        }};
    }
}
