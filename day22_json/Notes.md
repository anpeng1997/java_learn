##JSON 
* java常见的json解析器:
    1. `Jsonlib`
    2. `Gson`
    3. `fastjson` (alibaba open source)
    4. `jackson`  (spring mvc 内置)
* 导入jackson jar 包
* `ObjectMapper objectMapper = new ObjectMapper();`  
常用方法：
    1. writeValueAsString() //将对象装换成json字符串
    2. readValue() //将json字串转换成对象
* 细节
    1. 注解：
        1. `@JsonIgnore`  忽视该属性
        2. `@JsonFormat`  属性值的格式化 : `@JsonFormat("yyyy-MM-dd")`