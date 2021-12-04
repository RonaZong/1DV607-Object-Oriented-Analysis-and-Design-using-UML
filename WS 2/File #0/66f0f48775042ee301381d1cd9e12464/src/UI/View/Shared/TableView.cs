using System;
using System.Collections.Generic;
using System.Linq;
using Alba.CsConsoleFormat;
using static System.ConsoleColor;

namespace UI.View.Shared
{
    public interface ITableBuilder
    {
        ITableBuilder AddHeaders(IEnumerable<string> headers);
        ITableBuilder AddHeader(string header);
        ITableBuilder AddRows(IEnumerable<object[]> values);
        ITableBuilder AddRow(object[] row);
        Document Build();
    }

    public abstract class AbstractTableBuilder : ITableBuilder
    {
        protected virtual ConsoleColor? HeaderColor { get; set; }
        protected virtual ConsoleColor? RowColor { get; set; }

        protected List<string> Headers { get; set; } = new List<string>();
        protected List<object[]> Rows { get; set; } = new List<object[]>();

        public virtual ITableBuilder AddHeader(string header)
        {
            Headers.Add(header);
            return this;
        }

        public virtual ITableBuilder AddHeaders(IEnumerable<string> headers)
        {
            Headers = headers?.ToList();
            return this;
        }

        public virtual ITableBuilder AddRow(object[] row)
        {
            Rows.Add(row);
            return this;
        }

        public virtual ITableBuilder AddRows(IEnumerable<object[]> values)
        {
            Rows = values?.ToList();
            return this;
        }

        public abstract Document Build();
    }

    public class TableBuilder : AbstractTableBuilder
    {
        protected override ConsoleColor? HeaderColor => Yellow;

        public override Document Build()
        {
            var padding = new Thickness(1, 0);
            var document = new Document
            {
                Children =
                {
                    new Grid
                    {
                        Stroke = new LineThickness(
                            LineWidth.Single, LineWidth.Single),
                        Columns =
                        {
                            Headers.Select(_ => new Column { Width = GridLength.Auto })
                        },
                        Children =
                        {
                            Headers.Select(
                                header => new Cell(header) { Color = HeaderColor, Padding = padding }),
                            Rows.Select(value => {
                                return value.Select(x =>
                                    new Cell { Children = { x.ToString() }, Color = RowColor, Padding = padding });
                            })
                        }
                    }
                }
            };
            return document;
        }
    }

    public class ExceptionTableBuilder : TableBuilder
    {
        protected override ConsoleColor? HeaderColor => Red;
        protected override ConsoleColor? RowColor => Red;
    }

    public class InformationTableBuilder : TableBuilder
    {
        protected override ConsoleColor? HeaderColor => Blue;
        protected override ConsoleColor? RowColor => Blue;
    }
}
