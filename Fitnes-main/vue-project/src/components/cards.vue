<template>
  <div class="First container">
    <div class="row">
      <div class="col-md-4">
        <div class="c1 card">
          <img
            src="https://via.placeholder.com/150"
            class="card-img-top"
            alt="Квартиры"
          />
          <div class="card-body">
            <h5 class="card-title">Агент</h5>
            <p class="card-text">Имя: Даниил
              Номер телефона: 8 (918) 585-73-10</p>
            <a href="#" class="btn ">Профиль</a>
          </div>
        </div>
      </div>

      <div class="col-md-4">
        <div class="c1 card">
          <img
            src="https://via.placeholder.com/150"
            class="card-img-top"
            alt=""
          />
          <div class="card-body">
            <h5 class="card-title">Агент</h5>
            <p class="card-text">Имя: Олег
              Номер телефона: 8 (991) 892-45-12
            </p>
            <a href="#" class="btn ">Профиль</a>
          </div>
        </div>
      </div>

      <div class="col-md-4">
        <div class="c1 card">
          <img
            src="https://via.placeholder.com/150"
            class="card-img-top"
            alt="Товар 3"
          />
          <div class="card-body">
            <h5 class="card-title">Объекты</h5>
            <p class="card-text">Улица:Пушкинская 119
              Жилой комплекс: Пушкин
              Цена: 27.000.000 рублей
            </p>
            <a href="#" class="btn ">Профиль</a>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup></script>

<style scoped>
.First {
  margin-top: 7%;
}
.c1 {
  background: rgb(255, 255, 255);
  background: linear-gradient(
    241deg,
    rgb(0, 0, 0) 0%,
    rgb(255, 255, 255) 100%
  );
  animation: gradient 5s infinite linear;
  background-size: 400%;
}
.btn{
    color: aliceblue;
    background-color: rgb(35, 25, 66);
}
@media (max-width: 768px) {
  .search-bar input {
    width: 150px;
  }
}

@media (max-width: 480px) {
  .First {
    flex-direction: column;
    padding: 10px;
  }

  .c1 {
    width: 100%;
    margin-bottom: 7%;
  }

  .buttons {
    margin-top: 10px;
  }

  .buttons button {
    margin-left: 0;
    display: block;
    width: 100%;
    margin-top: 7px;
  }
}
</style>
