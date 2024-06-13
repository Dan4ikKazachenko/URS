<script setup>
import Header from './Header.vue';
</script>

<template>
  <header>
    
    <div
      id="carouselExampleControlsNoTouching"
      class="First carousel slide"
      data-bs-touch="false"
    >
      <div class="carhead carousel-inner">
        <div class="carousel-item active">
          <img
            src="/src/assets/pic/logoAN.jpeg"
            class="d-block w-100"
            alt="..."
          />
          <div class="carousel-caption d-none d-md-block">
            <h3>Вставить текст</h3>
            <!-- вставить кнопку -->
          </div>
        </div>

        <div class="carousel-item">
          <img
            src="https://pizzarezept.ru/wp-content/uploads/2023/06/sa-15.jpg"
            class="d-block w-100"
            alt="..."
          />
          <div class="carousel-caption d-none d-md-block">
            <h5>Вставить текст</h5>
            <!-- вставить кнопку -->
          </div>
        </div>
        <div class="carousel-item">
          <img
            src="https://kredit-on.ru/wp-content/uploads/d/6/6/d66fa196779f5057289039838139b487.jpeg"
            class="d-block w-100"
            alt="..."
          />
          <div class="carousel-caption d-none d-md-block">
            <h5>Вставить текст</h5>
            <!-- вставить кнопку -->
          </div>
        </div>
      </div>
      <button
        class="carousel-control-prev"
        type="button"
        data-bs-target="#carouselExampleControlsNoTouching"
        data-bs-slide="prev"
      >
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Previous</span>
      </button>
      <button
        class="carousel-control-next"
        type="button"
        data-bs-target="#carouselExampleControlsNoTouching"
        data-bs-slide="next"
      >
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Next</span>
      </button>
    </div>
  </header>

  <main></main>
</template>

<style scoped>
.carousel-item{
  align-items: center;
}
</style>
