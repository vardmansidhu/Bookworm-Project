import { useEffect, useState } from "react";
import { Button, ButtonGroup, Container, Tab, Tabs } from "react-bootstrap";
import MyCard from "./MyCard";

export default function ProductsByLanguages( {productType} ) {
  const [languages, setLanguages] = useState([]);
  const [language, setLanguage] = useState(null);

  const handleSelect = (key) => {
    fetch(`http://localhost:8080/api/language/getByTypeId/${key}`)
      .then((res) => res.json())
      .then((res) => setLanguages(res));
  }

  const handleClick = (languageId) => {
    setLanguage(languageId);
  }
  return (
    <Tabs
      defaultActiveKey="1"
      id="justify-tab-example"
      className="mb-3"
      justify
      onSelect={handleSelect}
    >
      {productType.map((val) => (
        <Tab eventKey={val.typeId} title={val.typeDesc}>
          <Container className="justify-content-center">
            <ButtonGroup aria-label="Basic example">
              <Button variant="secondary" onClick={()=>setLanguage(null)}>All Languages</Button>
              {languages.map(lang => (
                <Button variant="secondary" onClick={()=>handleClick(lang.languageId)}>{lang.languageDesc}</Button>
              ))}
            </ButtonGroup>
            <MyCard typeId={val.typeId} selectedLanguage={language}></MyCard>
          </Container>
        </Tab>
      ))}
    </Tabs>
  );
}
