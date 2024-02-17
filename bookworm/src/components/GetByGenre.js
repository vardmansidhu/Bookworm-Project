
import React, { useEffect, useState } from "react";
import { useParams } from "react-router-dom";

export default function GetByGenre() {
  const { genreName } = useParams();
  const [gnere, setGenre] = useState({});

  useEffect(() => {
    fetch(`http://localhost:8080/api/genre/getGenreByName/${genreName}`)
      .then((res) => res.json())
      .then((res) => setGenre(res));
  }, [genreName]);
  return (
    <div>
      <div>
        {console.log(gnere)}
        <h2>Genre Details</h2>
        <p>Genre ID : {gnere.genreid}</p>
        <p>Genre Desc : {gnere.genredesc}</p>
      </div>
    </div>
  );
}
