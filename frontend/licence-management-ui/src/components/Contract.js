import ButtonTxt from "./ButtonTxt";

const Contract = ({contract}) => {
    const onClick = () => {
        console.log('click');
    };
    return (
        <>
            <div className='contract flex justify-items-start py-2 border-b-2'>
                <span className='tbl-row tbl-content'>{contract.company.name}</span>
                <span className='tbl-row tbl-content'>{contract.dateStart.toString().substring(0, 10)}</span>
                <span className='tbl-row tbl-content'>{contract.dateStop.toString().substring(0, 10)}</span>
                <span className='tbl-row tbl-content'>{contract.version}</span>
                <span className='tbl-row tbl-content btnTxt onHoverChangeCol'>
        <ButtonTxt name={'Edit'} onClick={onClick}/>
        </span>
                <span className='tbl-row tbl-content btnTxt onHoverChangeCol'>
          <ButtonTxt name={'Delete'} onClick={onClick}/>
        </span>
                <span className='tbl-row tbl-content btnTxt onHoverChangeCol'>
          <ButtonTxt name={'Details'} onClick={onClick}/>
        </span>
            </div>
        </>
    );
};

export default Contract;
