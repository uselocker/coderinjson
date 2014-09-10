implementation of container for data which builds
JSON string format. container has recursive algorithm
for building. frame size about 100 byte. in this case
for unwinding string for 1M objects JVM needs stack size
about 90Mb (64-bit JVM)
class ManualTest.java contains simple example
specification:
1. api has two public classes for instancing. JsonObject
is the main and works with keys. JsonArrayNode realize
arrays as nested structure for adding to JsonObject as
value and works with indexes.
2. method which adds nested structure can throw
"CyclicLinkException" if to try add itself to itself:
add(String key, JsonObject value) throws CyclicLinkException.
but now algorithm not checks other situation for cyclic
link adding. if programmer get wrong and add cyclic link
JVM will drop with StackOverflowError.
3. all add and set methods for "key" value checks it and
can throw IllegalArgumentException if key not coincides
with condition (key != null && key.length() > 0).
4. references on all nested structures will work after
added it in place to upper structure and remain modifiable.
in this case for changing data better work with reference
on the same level. methods that work by keys will work on
first found key(last added).
5. CRUD operations for JsonArrayNode works only on the
same level and for JsonObject types can going into nested
structure for modify data.
