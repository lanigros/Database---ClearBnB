import styled from "styled-components";

const HomeFormStyle = styled.div`
height: inherit;

form{
display: flex;
flex-direction: column;
justify-content: center;
align-items: center;
flex-wrap: wrap;
}

input{
  margin: 5px;
  max-width: 100%;
  width: 200px;
}

input[type="checkbox"]{
  width: 50px;
}

.address{
  width: 44vw;
  flex-direction: row;
  flex-wrap: wrap;
  margin: 2vw;
  margin-right: -2vw;
}

.address input{
  width: 40%;
}

.conditions{
  flex-direction: row;
  flex-wrap: wrap;
  width: 30vw;
  margin: 2vw;
  margin-left: 4vw;

}

.conditions input{
  width: 20vw;
}

.images{
  justify-content: center;
  flex-direction: column;
  flex-wrap: wrap;
  width: 44vw;
  margin: 2vw;
  margin-left: -2vw;
}

.images input{
  width: 100%;
}

.amenities{
  width: 50vw;
  justify-content: center;
  align-items: center;
  margin-bottom: 3vh;
}

button{
  width: 20vw;
  height: 6vh;
}




`

export default HomeFormStyle