<#include "../../master.ftl">

<#macro page_title>Estudiantes</#macro>

<#macro main>
    <div class="max-w-sm rounded overflow-hidden shadow-lg float-left">
        <img class="w-full" src="https://codely.tv/pro/img/bg/cursos-codelytv-pro.png" alt="Sunset in the mountains">
        <div class="px-6 py-4">
            <div class="font-bold text-xl mb-2">Estudiantes</div>
            <p class="text-gray-700 text-base">
                Actualmente CodelyTV Pro cuenta con <b>${students_counter}</b> estudiantes.
            </p>
        </div>
    </div>

    <#include "partials/new_student_form.ftl">
</#macro>
