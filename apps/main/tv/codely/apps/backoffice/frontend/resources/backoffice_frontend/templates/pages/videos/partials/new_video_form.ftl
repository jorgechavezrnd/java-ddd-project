<form class="w-full max-w-lg float-right" method="post" action="/videos">
    <h2 class="block uppercase tracking-wide text-gray-700 text-3xl font-bold mb-2">Crear video</h2>
    <div class="flex flex-wrap mb-6 -mx-3">
        <div class="w-full md:w-full px-3 mb-6 md:mb-0">
            <label class="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2" for="grid-first-name">
                Identificador
            </label>
            <input class="<#if errors['id']?? >border border-red-500</#if> appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500"
                   id="grid-first-name" type="text" name="id" placeholder="En formado UUID"
                   value="${(inputs['id'])!generated_uuid}">

            <#if errors['id']?? >
                <#list errors['id'] as errorMessage>
                    <p class="text-red-500 text-xs italic">${errorMessage}</p>
                </#list>
            </#if>
        </div>
    </div>
    <div class="flex flex-wrap -mx-3 mb-6">
        <div class="w-full md:w-1/2 px-3 mb-6 md:mb-0">
            <label class="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2" for="grid-type">
                Tipo
            </label>
            <input class="<#if errors['type']?? >border border-red-500</#if> appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500"
                   id="grid-type" type="text" name="type" placeholder="Práctica"
                   value="${(inputs['type'])!""}">

            <#if errors['type']?? >
                <#list errors['type'] as errorMessage>
                    <p class="text-red-500 text-xs italic">${errorMessage}</p>
                </#list>
            </#if>
        </div>
        <div class="w-full md:w-1/2 px-3">
            <label class="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2" for="grid-title">
                Título
            </label>
            <input class="<#if errors['title']?? >border border-red-500</#if> appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500"
                   id="grid-title" type="text" name="title" placeholder="Implementar controlador"
                   value="${(inputs['title'])!""}">

            <#if errors['title']?? >
                <#list errors['title'] as errorMessage>
                    <p class="text-red-500 text-xs italic">${errorMessage}</p>
                </#list>
            </#if>
        </div>
        <div class="w-full md:w-1/2 px-3">
            <label class="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2" for="grid-url">
                URL
            </label>
            <input class="<#if errors['url']?? >border border-red-500</#if> appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500"
                   id="grid-url" type="text" name="url" placeholder="http://codelytv/video/test"
                   value="${(inputs['url'])!""}">

            <#if errors['url']?? >
                <#list errors['url'] as errorMessage>
                    <p class="text-red-500 text-xs italic">${errorMessage}</p>
                </#list>
            </#if>
        </div>

        <div class="w-full md:w-1/2 px-3">
            <label class="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2" for="grid-course-id">
                ID del Curso
            </label>
            <div class="relative">
                <select class="block appearance-none w-full bg-gray-200 border border-gray-200 text-gray-700 py-3 px-4 pr-8 rounded leading-tight focus:outline-none focus:bg-white focus:border-gray-500"
                        id="grid-course-id" name="courseId">
                    <#if course_ids?? >
                        <#if course_ids?size == 0 >
                            <option>Not course registered</option>
                        </#if>
                        <#list course_ids as courseIdValue>
                            <option <#if inputs['courseId']?? && inputs['courseId'] == courseIdValue >selected</#if>
                                    value="${courseIdValue}">
                                ${courseIdValue}
                            </option>
                        </#list>
                    </#if>
                </select>
                <div class="pointer-events-none absolute inset-y-0 right-0 flex items-center px-2 text-gray-700">
                    <svg class="fill-current h-4 w-4" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20"><path d="M9.293 12.95l.707.707L15.657 8l-1.414-1.414L10 10.828 5.757 6.586 4.343 8z"/></svg>
                </div>
            </div>

            <#if errors['courseId']?? >
                <#list errors['courseId'] as errorMessage>
                    <p class="text-red-500 text-xs italic">${errorMessage}</p>
                </#list>
            </#if>
        </div>
    </div>
    <div class="flex flex-wrap mb-6">
        <button class="md:w-full bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline"
                type="submit">
            Crear video!
        </button>
    </div>
</form>
