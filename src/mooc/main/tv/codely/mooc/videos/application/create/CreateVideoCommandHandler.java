package tv.codely.mooc.videos.application.create;

import tv.codely.mooc.courses.domain.CourseId;
import tv.codely.mooc.videos.domain.VideoId;
import tv.codely.mooc.videos.domain.VideoTitle;
import tv.codely.mooc.videos.domain.VideoType;
import tv.codely.shared.domain.Service;
import tv.codely.shared.domain.VideoUrl;
import tv.codely.shared.domain.bus.command.CommandHandler;

@Service
public final class CreateVideoCommandHandler implements CommandHandler<CreateVideoCommand> {
    private final VideoCreator creator;

    public CreateVideoCommandHandler(VideoCreator creator) {
        this.creator = creator;
    }

    @Override
    public void handle(CreateVideoCommand command) {
        VideoId    id       = new VideoId(command.id());
        VideoType  type     = new VideoType(command.type());
        VideoTitle title    = new VideoTitle(command.title());
        VideoUrl   url      = new VideoUrl(command.url());
        CourseId   courseId = new CourseId(command.courseId());

        creator.create(id, type, title, url, courseId);
    }
}
