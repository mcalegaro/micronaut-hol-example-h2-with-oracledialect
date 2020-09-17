# Micronaut HOL Example
>## Micronaut HOL Example
>This is a Micronaut example application used with the Micronaut + Oracle Cloud Hands-on-Lab (HOL). 
>https://github.com/graemerocher/micronaut-hol-example

Micronaut init. From https://oracle.github.io/learning-library/developer-library/micronaut-oci-atp/workshops/freetier/

Running under Windows + OpenJDK Runtime Environment GraalVM CE 20.2.0 (build 11.0.8+10-jvmci-20.2-b03), could'nt execute `./gradlew run -t`, causing error:
<details>
  <summary>details:</summary>

```
[ForkJoinPool.commonPool-worker-7] ERROR i.m.context.DefaultBeanContext - Parallel Bean definition [io.micronaut.scheduling.io.watch.osx.MacOsWatchThread] could not be loaded: Error instantiating bean of type [io.micronaut.scheduling.io.watch.osx.MacOsWatchThread]: Unable to load library 'Carbon':
The specified module could not be found.

The specified module could not be found.

The specified module could not be found.

Native library (win32-x86-64/Carbon.dll) not found in resource path ...
```

</details>

Run only `./gradlew run`
