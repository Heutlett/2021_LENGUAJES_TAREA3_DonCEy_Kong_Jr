#include <stdio.h>
#include <allegro5/allegro.h>
#include <allegro5/allegro_native_dialog.h>
#include <allegro5/allegro_image.h>
#include "unistd.h"

int main() {

    ALLEGRO_DISPLAY *display;
    ALLEGRO_EVENT_QUEUE *queue;
    ALLEGRO_TIMER *timer;

    ALLEGRO_BITMAP *monkey_bitmap;

    al_init();

    display = al_create_display(660,400);
    queue = al_create_event_queue();
    timer = al_create_timer(1.0/60);

    al_install_keyboard();
    al_register_event_source(queue, al_get_keyboard_event_source());
    al_register_event_source(queue, al_get_display_event_source(display));
    al_register_event_source(queue, al_get_timer_event_source(timer));

    al_init_image_addon();
    monkey_bitmap = al_load_bitmap("../resources/walk_right2.png");
    assert(monkey_bitmap != NULL);

    bool running = true;
    float x = 0;
    int width = al_get_display_width(display);
    al_start_timer(timer);

    while (running) {

        ALLEGRO_EVENT event;
        al_wait_for_event(queue, &event);

        if(event.type == ALLEGRO_EVENT_DISPLAY_CLOSE){
            running = false;
        }

        if(event.type == ALLEGRO_EVENT_TIMER){
            al_clear_to_color(al_map_rgba_f(1,50,1,20));
            al_draw_bitmap(monkey_bitmap, x += 1,0,0);
            al_flip_display();
        }

        if(x > width) x = - al_get_bitmap_width(monkey_bitmap);
    }

    al_destroy_display(display);
    al_uninstall_keyboard();
    al_destroy_timer(timer);
    al_destroy_bitmap(monkey_bitmap);

    return 0;
}
