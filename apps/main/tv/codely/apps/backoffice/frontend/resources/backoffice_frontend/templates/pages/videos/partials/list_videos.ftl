<h3 class="font-sans text-gray-800 text-center text-3xl mb-10">Videos existentes</h3>

<table class="text-left w-full border-collapse">
    <thead>
    <tr>
        <th class="py-4 px-6 bg-grey-lightest font-bold uppercase text-sm text-grey-dark border-b border-grey-light">Id</th>
        <th class="py-4 px-6 bg-grey-lightest font-bold uppercase text-sm text-grey-dark border-b border-grey-light">Tipo</th>
        <th class="py-4 px-6 bg-grey-lightest font-bold uppercase text-sm text-grey-dark border-b border-grey-light">Título</th>
        <th class="py-4 px-6 bg-grey-lightest font-bold uppercase text-sm text-grey-dark border-b border-grey-light">URL</th>
        <th class="py-4 px-6 bg-grey-lightest font-bold uppercase text-sm text-grey-dark border-b border-grey-light">ID del curso</th>
    </tr>
    </thead>
    <tbody id="videos-list">

    </tbody>
</table>

<script>
    const tableBody = document.getElementById("videos-list");

    fetch("/api/videos")
        .then(function (response) {
            return response.json();
        })
        .then(function (videos) {
            tableBody.innerHTML = "";

            videos.forEach(function (video) {
                let videoRow = document.createElement("tr");

                videoRow.appendChild(tableCellFor(video.id));
                videoRow.appendChild(tableCellFor(video.type));
                videoRow.appendChild(tableCellFor(video.title));
                videoRow.appendChild(tableCellFor(video.url));
                videoRow.appendChild(tableCellFor(video.courseId));

                tableBody.appendChild(videoRow);
            });
        });

    function tableCellFor(text) {
        const cell = document.createElement("td");

        cell.appendChild(document.createTextNode(text));

        return cell;
    }
</script>
